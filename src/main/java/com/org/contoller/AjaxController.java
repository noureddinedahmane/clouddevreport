package com.org.contoller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.org.entities.Approvement;
import com.org.entities.ApprovementGroup;
import com.org.entities.Client;
import com.org.entities.Deviation;
import com.org.entities.Notification;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierDeviationReport;

@Controller
@RequestMapping(value = "/admin/")
public class AjaxController {

	@Autowired
	private IMetierDeviationReport metier;
	
	@Autowired
	private IMetierClient metierClient;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	
	}
	
	
	@RequestMapping(value = "listNotReadNotifications", method = RequestMethod.GET)
	public @ResponseBody String listDeviations(Model model,Principal principal) {
		List<List<String>> response = new ArrayList<List<String>>();
		
		Client client = metierClient.getClientByUserName(principal.getName());
		List<Notification>  notifications = metier.listNotReadNotificationByClient(client);
		
		for(Notification notification: notifications) {
             List<String> record = new ArrayList<String>();
             record.add(notification.getIdNotification().toString());
             record.add(notification.getTitleNotification());
             record.add(notification.getBodyNotification());
             record.add(notification.getIdDeviation().toString());
             
             response.add(record);
             
		}
		
		return new Gson().toJson(response);
	}
	
	//make approvement
	@RequestMapping(value = "makeApprovement", method = RequestMethod.GET)
	public @ResponseBody String makeApprovement(Locale locale, Model model,Principal principal, HttpServletRequest request) {
		//approvent rules:
		//1- The user must belong to the group
		//2- the deviation must not be expired
		//3- if its already approved, only the first user can edit the approvement again
		
		
	    String[] message = new String[3];
	    
		String approvementID = request.getParameter("approvementID");
		String approved =  request.getParameter("approved"); 
		String rejected =  request.getParameter("rejected");
		String comment = request.getParameter("comment");
		
		Client client = metierClient.getClientByUserName(principal.getName());
		Approvement approvement = metier.getApprovement(new Long(approvementID), client);
		
		if(approvement != null) {
			ApprovementGroup approvementGroup = approvement.getApprovementGroup();
			Deviation deviation = approvement.getDeviation();
			boolean isDeviationExpired = false;
			boolean isUserInGroup = metier.isUserInGroup(client, approvementGroup);
			if(deviation.getEndDatePeriod() != null) {
				 isDeviationExpired = new Date().after(deviation.getEndDatePeriod());
			}
			boolean isAlreadyApproved = false;
			if(approvement.isRejected() || approvement.isApproved()) {
				if(approvement.getClient().getIdClient() != client.getIdClient()) {
					isAlreadyApproved = true;
				}

			}
			
			//make sure that the user belongs to the approvementgroup
			if(!isUserInGroup || isDeviationExpired || isAlreadyApproved) {
				
				if(!isUserInGroup) {
					message[0] = "error";
					message[1] = messageSource.getMessage("label.userNotInGroup", null, locale);
					
				}
				else if(isDeviationExpired) {
					message[0] = "error";
					message[1] = messageSource.getMessage("label.deviationExpired", null, locale);
					
				}else if(isAlreadyApproved) {
					message[0] = "error";
					message[1] = messageSource.getMessage("label.noPermitionToEditApprovement", null, locale);
					
				}
			}			
			else {
				
				if(approved.equals("true")) {
				   approvement.setApproved(true);
				}
				else {
					approvement.setApproved(false);
				}
				
				if(rejected.equals("true")) {
					approvement.setRejected(true);
				}
				else {
					approvement.setRejected(false);
				}
				
				approvement.setComment(comment);
				approvement.setDate(new Date());
				
				//update the approvement
				metier.updateApprovement(approvement, client);
				
			    //add a notification
				this.addNotification(deviation, locale, client, approvement.isApproved());
				
				message[0] = "success";
				message[1] = messageSource.getMessage("label.approvementDone", null, locale);
				message[2] = approvement.getDate().toString();
				
			}
		}else {
			message[0] = "error";
			message[1] = messageSource.getMessage("label.approvementNotExist", null, locale);
	
		} 

		return new Gson().toJson(message);
	}
	
	public void addNotification(Deviation deviation, Locale locale, Client client, boolean approved) {
		//add a notification
		Notification notification = new Notification();
		
		String title = null;
		String body = null;
		
		if(approved) {
			title = messageSource.getMessage("label.deviationApproved", null, locale);
			body = messageSource.getMessage("label.deviationWasApproved", null, locale) + " " + client.getName() + client.getPrenom();
			body += messageSource.getMessage("label.clickToViewDeviation", null, locale) + deviation.getDeviationRef();
		}else {
			//rejected
			title = messageSource.getMessage("label.newRejected", null, locale);
			body = messageSource.getMessage("label.deviationWasRejected", null, locale) +  " " + client.getName() + client.getPrenom();
			body += messageSource.getMessage("label.clickToViewDeviation", null, locale)+ deviation.getDeviationRef();
		}
	
		notification.setTitleNotification(title);
		notification.setBodyNotification(body);
		notification.setRead(false);
		notification.setIdDeviation(deviation.getIdDeviation().toString());
		notification.setClient(client);
		
		metier.addNotication(notification);
		
	}
	
	@RequestMapping(value = "viewNotification", method = RequestMethod.GET)
	public  ModelAndView viewNotification(Model model,Long idNotification, Principal principal) {
		Notification notification = metier.getNotification(idNotification);
		notification.setRead(true);
		metier.updateNotication(notification);
		
		/*
		 * it  may be better that the user click on the notification to go the see the deviation, that this notification will be deleted
		 * metier.deleteNotification(idNotification);
		 */
		
		return new ModelAndView("redirect:editDeviation?idDeviation=" + notification.getIdDeviation());
	}
	
	
}
