package com.org.daoInter;

import java.util.List;

import com.org.entities.Calendar;
import com.org.entities.Client;
import com.org.entities.Event;

public interface IDaoCalendar {

	public Calendar addCalendar(Calendar calendar, Client client);
	public Calendar getCalendar(Long idCalendar, Client client);
	public Calendar updateCalendar(Calendar calendar, Client client);
	public boolean deleteCalendar(Long idCalendar, Client client);
	public List<Calendar> listCalendar(int min, int max, Client client);
	
	
	//events
	public Event addEvent(Event event,Calendar calendar,Client client);
	public Event getEvent(Long idEvent, Client client);
	public Event updateEvent(Event event, Client client);
	public boolean deleteEvent(Long idEvent, Client client);
	public List<Event> listCalendarEvent(Calendar calendar, Client client);
	
}
