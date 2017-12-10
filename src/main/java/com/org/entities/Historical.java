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
public class Historical implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idHistorical;
	
	private Date date;
	private String action; // this varibale contain the action performed by the user, it can saving deviation, modfiying ..
	
	@ManyToOne
	@JoinColumn(name="idDeviation")
	private Deviation deviation;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Deviation getDeviation() {
		return deviation;
	}
	public void setDeviation(Deviation deviation) {
		this.deviation = deviation;
	}
	public Long getIdHistorical() {
		return idHistorical;
	}
	public void setIdHistorical(Long idHistorical) {
		this.idHistorical = idHistorical;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Historical(Date date, String action) {
		super();
		this.date = date;
		this.action = action;
	}
	public Historical() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
