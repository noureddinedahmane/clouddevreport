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
public class Note implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNote;
	
	private String title;
	private String note;
	private Date date = new Date();
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Long getIdNote() {
		return idNote;
	}
	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Note(String title, String note) {
		super();
		this.title = title;
		this.note = note;
	}
	
	
	
	
	

}
