package com.org.entities;

import java.util.Date;
import java.util.List;

public class Email {

	 private String subject;
	 private String body;
	 private Date date;
	 private String sender;
	 private List<String> receiver;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public List<String> getReceiver() {
		return receiver;
	}
	public void setReceiver(List<String> receiver) {
		this.receiver = receiver;
	}
	public Email(String subject, String body, Date date, String sender,
			List<String> receiver) {
		super();
		this.subject = subject;
		this.body = body;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
	}
	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 
	 
	 
}
