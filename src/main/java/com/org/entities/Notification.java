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
public class Notification implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNotification;
	
	private Date dateNotification;
	private String titleNotification;
	private String bodyNotification;
	private boolean isRead;
	private String idDeviation;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;

	
	public String getIdDeviation() {
		return idDeviation;
	}

	public void setIdDeviation(String idDeviation) {
		this.idDeviation = idDeviation;
	}

	public Long getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(Long idNotification) {
		this.idNotification = idNotification;
	}

	public Date getDateNotification() {
		return dateNotification;
	}

	public void setDateNotification(Date dateNotification) {
		this.dateNotification = dateNotification;
	}

	public String getTitleNotification() {
		return titleNotification;
	}

	public void setTitleNotification(String titleNotification) {
		this.titleNotification = titleNotification;
	}

	public String getBodyNotification() {
		return bodyNotification;
	}

	public void setBodyNotification(String bodyNotification) {
		this.bodyNotification = bodyNotification;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Notification(Long idNotification, Date dateNotification, String titleNotification, String bodyNotification,
			boolean isRead) {
		super();
		this.idNotification = idNotification;
		this.dateNotification = dateNotification;
		this.titleNotification = titleNotification;
		this.bodyNotification = bodyNotification;
		this.isRead = isRead;
	}

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
