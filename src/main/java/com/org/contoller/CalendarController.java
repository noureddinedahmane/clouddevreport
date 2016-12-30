package com.org.contoller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.org.MetierImp.ImpMetierCalendar;
import com.org.entities.Calendar;
import com.org.entities.Client;
import com.org.entities.Event;
import com.org.metierInter.IMetierClient;

@Controller
@RequestMapping(value = "/admin/")
public class CalendarController {

	@Autowired
	private IMetierClient metierClient;
	
	@Autowired
	private ImpMetierCalendar metierCalendar;
	
	// show calendar
	@RequestMapping(value = "calendar", method = RequestMethod.GET)
	public String calendar(Model model, Principal principal) {
		Client client = metierClient.getClientByUserName(principal.getName());
		model.addAttribute("listCalendar", metierCalendar.listCalendar(0, 100, client));		
		return "calendar/calendar";
	}
	
	@ResponseBody
	@RequestMapping(value = "saveCalendar", method = RequestMethod.POST, produces = "application/json")
	public String saveCalendar(HttpServletRequest request, Principal principal) {
		String  message="";
		Client client = metierClient.getClientByUserName(principal.getName());
		
		String idCalendar = request.getParameter("idCalendar");
		String calendarName = request.getParameter("calendarName");
		
		if(idCalendar==""){
			//save new calendar
			Calendar calendar = new Calendar();
			calendar.setClient(client);
			calendar.setCalendarName(calendarName);
			metierCalendar.addCalendar(calendar, client);
			idCalendar=calendar.getIdCalendar()+"";
			message="Calendar has successfuly saved";
			
		}
		else{
		    //update calendar
			Calendar calendar = metierCalendar.getCalendar(new Long(idCalendar), client);
			calendar.setCalendarName(calendarName);
			metierCalendar.updateCalendar(calendar, client);
			message="Calendar has successfuly updated";
			
		}
		
		String json[]={message,idCalendar};
		Gson gs = new Gson();
		
		return gs.toJson(json);
	}
	
	@ResponseBody
	@RequestMapping(value = "deleteCalendar", method = RequestMethod.POST, produces = "application/json")
	public String deleteCalendar(HttpServletRequest request, Principal principal) {
		String  message="";
		Client client = metierClient.getClientByUserName(principal.getName());
		
		String idCalendar = request.getParameter("idCalendar");
		
		if(metierCalendar.deleteCalendar(new Long(idCalendar), client)){
			message="Calendar has been successfuly deleted";
		}else{
			message="Error, Calendar could not be removed";
		}
		

		
		String json[]={message,idCalendar};
		Gson gs = new Gson();
		
		return gs.toJson(json);
	}
		
	
	//add/update event
	@ResponseBody
	@RequestMapping(value = "saveEvent", method = RequestMethod.POST, produces = "application/json")
	public String saveEvent(HttpServletRequest request, Principal principal) throws ParseException {
		String  message="";
		Client client = metierClient.getClientByUserName(principal.getName());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		
		String idCalendar = request.getParameter("idCalendarEvent");
		String idEvent = request.getParameter("idEvent");
		String eventTitle = request.getParameter("eventTitle");
		String eventLocation = request.getParameter("eventLocation");
		Date eventStartDate = simpleDateFormat.parse(request.getParameter("eventStartDate"));
		Date eventEndDate = simpleDateFormat.parse(request.getParameter("eventEndDate"));
		String eventOccupation = request.getParameter("eventOccupation");
		String eventDescription = request.getParameter("eventDescription");
		String eventColor = request.getParameter("eventColor");
		
		Calendar calendar = metierCalendar.getCalendar(new Long(idCalendar), client);
	    if(calendar!=null){    	
	    	Event event;
	    	if(idEvent==""){
	    		event = new Event();
	    	}else{
	    		event = metierCalendar.getEvent(new Long(idEvent), client);
	    	}
	    	
		    event.setCalendar(calendar);
		    event.setLiblle(eventTitle);
		    event.setLocation(eventLocation);
		    event.setStartDate(eventStartDate);
		    event.setEndDate(eventEndDate);
		    event.setOccupation(eventOccupation);
		    event.setDescription(eventDescription);
		    event.setCategory(eventColor);
		    
		    if(idEvent==""){
				//save new event
			    metierCalendar.addEvent(event, calendar, client);
			    idEvent = event.getIdEvent()+"";
			    message="Event has been successfuly saved";
				
			}
			else{
			    //update event
				metierCalendar.updateEvent(event, client);
				message="Event has been successfuly saved";
			}
		    
	    }else{
	    	message="Calendar dos not exist";
	    	idEvent="-1";
	    }
		
		
		String json[]={message,idEvent};
		Gson gs = new Gson();
		
		return gs.toJson(json);
	}
	
	//get event
	@ResponseBody
	@RequestMapping(value = "getEvent", method = RequestMethod.POST, produces = "application/json")
	public String getEvent(HttpServletRequest request, Principal principal){
		Client client = metierClient.getClientByUserName(principal.getName());
		
		String idEvent = request.getParameter("idEvent");
		Event event = metierCalendar.getEvent(new Long(idEvent), client);
		
		String json[]={idEvent,event.getLiblle(),event.getLocation(),event.getStartDate().toString(),event.getEndDate().toString(),event.getOccupation(),event.getDescription()};
		Gson gs = new Gson();
		
		return gs.toJson(json);
	}
	
	//delete event
	@ResponseBody
	@RequestMapping(value = "deleteEvent", method = RequestMethod.POST, produces = "application/json")
	public String deleteEvent(HttpServletRequest request, Principal principal){
		String message="";
		Client client = metierClient.getClientByUserName(principal.getName());
		
		String idEvent = request.getParameter("idEvent");
		Event event = metierCalendar.getEvent(new Long(idEvent), client);
		
		if(metierCalendar.deleteEvent(new Long(idEvent), client)){
			message="Event has been successfuly removed";
		}else{
			message="Error, Message could not be removed";
		}
		
		String json[]={message,idEvent};
		Gson gs = new Gson();
		
		return gs.toJson(json);
	}

	
}
