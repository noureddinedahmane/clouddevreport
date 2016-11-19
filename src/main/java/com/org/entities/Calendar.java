package com.org.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Calendar implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCalendar;
	private String calendarName;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;

	@OneToMany(mappedBy="calendar")
	private List<Event> events;
	
	
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String getCalendarName() {
		return calendarName;
	}

	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	public Long getIdCalendar() {
		return idCalendar;
	}

	public void setIdCalendar(Long idCalendar) {
		this.idCalendar = idCalendar;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Calendar(String calendarName) {
		super();
		this.calendarName = calendarName;
	}

	public Calendar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
