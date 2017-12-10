package com.org.contoller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.entities.ApprovementGroup;
import com.org.entities.Client;
import com.org.entities.Configuration;
import com.org.entities.Domain;
import com.org.entities.UserApprovementGroup;
import com.org.metierInter.IMetierClient;
import com.org.metierInter.IMetierDeviationReport;
import com.org.util.Message;

@Controller
@RequestMapping(value = "/admin/")
public class ApprovementGroupController {

	@Autowired
	private IMetierDeviationReport metier;
	
	@Autowired
	private IMetierClient metierClient;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	//new domain
	@RequestMapping(value = "approvementGroup", method = RequestMethod.GET)
	public String newDomain(Model model,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		//get the domain in wich the approvement group will belong
		Domain domain =  client.getDomain();
				
	    model.addAttribute("approvementGroup",new ApprovementGroup());
	    model.addAttribute("listApprovementGroups", metier.listApprovementGroup(domain));
	    model.addAttribute("listDomains", metier.listDomainsByAccount(client.getAccount()));
	    model.addAttribute("idDomain", domain.getIdDomain());
	    
		return "approvementGroup/approvementGroup";
	}
	
	//edit approvementGroup
	@RequestMapping(value = "editApprovementGroup", method = RequestMethod.GET)
	public String editAPprovementGroup(Model model,Long idDomain, Long idApprovementGroup, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		//get the domain in wich the approvement group will belong
		Domain domain =  metier.getDomain(idDomain, client);
		ApprovementGroup  approvementGroup = metier.getApprovementGroup(idApprovementGroup, domain);
				
	    model.addAttribute("approvementGroup", approvementGroup);
	    model.addAttribute("listApprovementGroups", metier.listApprovementGroup(domain));
	    model.addAttribute("idDomain", idDomain);
	    
		return "approvementGroup/approvementGroup";
	}
	
	//save or approvement group
	@RequestMapping(value = "saveApprovementGroup", method = RequestMethod.POST)
	public ModelAndView saveDomain(Model model, ApprovementGroup approvementGroup, Principal principal,RedirectAttributes redirecAtrributes, HttpServletRequest request) {
		Message message=null;
		Client client = metierClient.getClientByUserName(principal.getName());
		
		Long idDomain = new Long(request.getParameter("idDomain"));
		
		//get the domain in wich the approvement group will belong
		Domain domain =  metier.getDomain(idDomain, client);
		
		if(approvementGroup.getIdApprovementGroup()==null){
			
			approvementGroup.setDateCreation(new Date());
			
			//save new approvemenGroup
			approvementGroup = metier.addApprovementGroup(approvementGroup, domain);
			
			//message
			message = new Message("The Group has been successfuly saved","success");
		}
		else{
			//update the task
			metier.updateApprovementGroup(approvementGroup, domain);
			message = new Message("The Group has been successfuly modified","success");
		}
		
		redirecAtrributes.addFlashAttribute("message", message);
		
		return new ModelAndView("redirect:approvementGroup?idDomain=" + idDomain);
	}
	
	//new domain
	@RequestMapping(value = "listGroups", method = RequestMethod.GET)
	public String listGroups(Model model,Long idDomain, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		model.addAttribute("listApprovementGroups", metier.listApprovementGroupByAccount(client.getAccount()));
		return "approvementGroup/groups";
	}
	
	//save new group
	@RequestMapping(value = "group", method = RequestMethod.GET)
	public String newGroup(Model model,Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		model.addAttribute("listDomains", metier.listDomainsByAccount(client.getAccount()));
		model.addAttribute("approvementGroup", new ApprovementGroup());
		return "approvementGroup/group";
	}
	
	//save or approvement group
	@RequestMapping(value = "newApprovementGroup", method = RequestMethod.POST)
	public ModelAndView newApprovementGroup(Model model, ApprovementGroup approvementGroup, Principal principal,RedirectAttributes redirecAtrributes, HttpServletRequest request) {
		Message message=null;
		Client client = metierClient.getClientByUserName(principal.getName());
		
		Long idDomain = new Long(request.getParameter("idDomain"));
		
		//get the domain in wich the approvement group will belong
		Domain domain =  metier.getDomain(idDomain, client);
		
		if(approvementGroup.getIdApprovementGroup()==null){
			
			approvementGroup.setDateCreation(new Date());
			
			//save new approvemenGroup
			approvementGroup = metier.addApprovementGroup(approvementGroup, domain);
			
			//message
			message = new Message("The Group has been successfuly saved","success");
		}
		else{
			//update the task
			metier.updateApprovementGroup(approvementGroup, domain);
			message = new Message("The Group has been successfuly modified","success");
		}
		
		redirecAtrributes.addFlashAttribute("message", message);
		
		return new ModelAndView("redirect:listGroups");
	}
	
	//add users to a group
	@RequestMapping(value = "addUsersToGroup", method = RequestMethod.GET)
	public String addMember(Model model, Long idApprovementGroup, Principal principal) {
		ApprovementGroup  apGroup = metier.getApprovementGroup(idApprovementGroup, null);
		
		Client client = metierClient.getClientByUserName(principal.getName());
		List<Client> listUsers =  metierClient.listClientByAccount(client.getAccount());
		List<Client> listUserInGroup = metier.listClientInUserGroup(apGroup);
		
		//create List of client to copy in the users dos not exist in the group
		List<Client> listUserNotGroup = new ArrayList<Client>();
		
		//remove the Users that already exist in the group from the listUSers
		for(Client user: listUsers) {
			boolean bool = false;
			for(Client userInGroup: listUserInGroup) {
				if(user.getIdClient() == userInGroup.getIdClient()) {
					bool = true;
					break;
				}
			}
			if(!bool) {
				listUserNotGroup.add(user);
			}
		}
		
		model.addAttribute("listUsers", listUserNotGroup);
		model.addAttribute("listUserInGroup", listUserInGroup);
		model.addAttribute("group", apGroup);
		
		return "approvementGroup/addMember";
	}
	//save Members to groups
	@RequestMapping(value = "saveMembersToGroups", method = RequestMethod.POST)
	public ModelAndView saveMembersToGroups(Model model,Principal principal, HttpServletRequest request) {
		
		String[] users = request.getParameterValues("users");
		String idGroup = request.getParameter("idGroup");
		
	
		for(int i=0; i<users.length;i++) {
			if(idGroup!="") {
				
				ApprovementGroup  apGroup = metier.getApprovementGroup(new Long(idGroup), null);
				Client user = metierClient.getClient(new Long(users[i]));
				
				if(apGroup!=null && user!=null) {
					
					//add the user to the group if dos not exist already
					if(!metier.isUserInGroup(user, apGroup)) {
						UserApprovementGroup userApprovementGroup = new UserApprovementGroup();
						userApprovementGroup.setClient(user);
						userApprovementGroup.setApprovementGroup(apGroup);
						
						metier.addUserApprovementGroup(userApprovementGroup);
					}
					
				}
			}
		}
		
		return new ModelAndView("redirect:addUsersToGroup?idApprovementGroup=" + idGroup);
	}
	
	
	
		
		
}