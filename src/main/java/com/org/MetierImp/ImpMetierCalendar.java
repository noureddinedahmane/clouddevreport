package com.org.MetierImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoCalendar;
import com.org.entities.Calendar;
import com.org.entities.Client;
import com.org.entities.Event;
import com.org.metierInter.IMetierCalendar;

@Transactional
public class ImpMetierCalendar implements IMetierCalendar{
	
	private IDaoCalendar daoCalendar;
	

	public IDaoCalendar getDaoCalendar() {
		return daoCalendar;
	}

	public void setDaoCalendar(IDaoCalendar daoCalendar) {
		this.daoCalendar = daoCalendar;
	}
	

	@Override
	public Calendar addCalendar(Calendar calendar, Client client) {
		return daoCalendar.addCalendar(calendar, client);
	}

	@Override
	public Calendar getCalendar(Long idCalendar, Client client) {
		return daoCalendar.getCalendar(idCalendar, client);
	}

	@Override
	public Calendar updateCalendar(Calendar calendar, Client client) {
		return daoCalendar.updateCalendar(calendar, client);
	}

	@Override
	public boolean deleteCalendar(Long idCalendar, Client client) {
		return daoCalendar.deleteCalendar(idCalendar, client);
	}

	@Override
	public List<Calendar> listCalendar(int min, int max, Client client) {
		return daoCalendar.listCalendar(min, max, client);
	}

	@Override
	public Event addEvent(Event event, Calendar calendar, Client client) {
		return daoCalendar.addEvent(event, calendar, client);
	}

	@Override
	public Event getEvent(Long idEvent, Client client) {
		return daoCalendar.getEvent(idEvent, client);
	}

	@Override
	public Event updateEvent(Event event, Client client) {
		return daoCalendar.updateEvent(event, client);
	}

	@Override
	public boolean deleteEvent(Long idEvent, Client client) {
		return daoCalendar.deleteEvent(idEvent, client);
	}

	@Override
	public List<Event> listCalendarEvent(Calendar calendar, Client client) {
		return daoCalendar.listCalendarEvent(calendar, client);
	}

}
