package com.org.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.org.daoInter.IDaoCalendar;
import com.org.entities.Calendar;
import com.org.entities.Client;
import com.org.entities.Event;

public class ImpDaoCalendar implements IDaoCalendar{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Calendar addCalendar(Calendar calendar, Client client) {
		calendar.setClient(client);
		em.persist(calendar);
		
		return calendar;
	}

	@Override
	public Calendar getCalendar(Long idCalendar, Client client) {
		Calendar calendar = em.find(Calendar.class, idCalendar);
		if(calendar!=null){
			if(calendar.getClient().getIdClient().equals(client.getIdClient())){
				
				return calendar;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public Calendar updateCalendar(Calendar calendar, Client client) {
		calendar.setClient(client);
		em.merge(calendar);
		
		return calendar;
		
	}

	@Override
	public boolean deleteCalendar(Long idCalendar, Client client) {
		Calendar calendar =  em.find(Calendar.class, idCalendar);
		if(calendar!=null){
			if(calendar.getClient().getIdClient().equals(client.getIdClient())){
				em.remove(calendar);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public List<Calendar> listCalendar(int min, int max, Client client) {
		Query req = em.createQuery("select cl from Calendar cl where cl.client=:c");
		req.setParameter("c", client);
		req.setFirstResult(min);
		req.setMaxResults(max);
		
		return req.getResultList();
	}

	@Override
	public Event addEvent(Event event, Calendar calendar, Client client) {
		event.setCalendar(calendar);
		em.persist(event);
		
		return event;
	}

	@Override
	public Event getEvent(Long idEvent, Client client) {
		
		Event event = em.find(Event.class, idEvent);
		if(event!=null){
           if(event.getCalendar().getClient().getIdClient().equals(client.getIdClient())){
				return event;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public Event updateEvent(Event event, Client client) {
		 if(event.getCalendar().getClient().getIdClient().equals(client.getIdClient())){
			em.merge(event);
			return event;
		}else{
			return null;
		}
	}

	@Override
	public boolean deleteEvent(Long idEvent, Client client) {
		Event event = em.find(Event.class, idEvent);
		if(event!=null){
			 if(event.getCalendar().getClient().getIdClient().equals(client.getIdClient())){
				em.remove(event);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}

	@Override
	public List<Event> listCalendarEvent(Calendar calendar, Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
