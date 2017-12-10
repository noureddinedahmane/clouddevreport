package com.org.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserApprovementGroup implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUserApprovementGroup;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="idApprovementGroup")
	private ApprovementGroup approvementGroup;
	
	
	public void setApprovementGroup(ApprovementGroup approvementGroup) {
		this.approvementGroup = approvementGroup;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Long getIdUserApprovementGroup() {
		return idUserApprovementGroup;
	}
	public void setIdUserApprovementGroup(Long idUserApprovementGroup) {
		this.idUserApprovementGroup = idUserApprovementGroup;
	}
	
	public UserApprovementGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
