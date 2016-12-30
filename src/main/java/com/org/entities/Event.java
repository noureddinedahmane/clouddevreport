package com.org.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Event implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEvent;
	
	private Date startDate;
	private Date endDate;
	private String liblle;
	private String category;
	private String location;
	private String description;
	private String occupation;//values=occupe,libre, provisoire, absent
	
	
	@ManyToOne
	@JoinColumn(name="idCalendar")
	private Calendar calendar;

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLiblle() {
		return liblle;
	}

	public void setLiblle(String liblle) {
		this.liblle = liblle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}



	public Event(Date startDate, Date endDate, String liblle, String category,
			String location, String description, String occupation) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.liblle = liblle;
		this.category = category;
		this.location = location;
		this.description = description;
		this.occupation = occupation;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
