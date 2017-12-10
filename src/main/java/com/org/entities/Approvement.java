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
public class Approvement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idApprovement;
	
	private boolean approved;
	private boolean rejected;
	private String comment;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="idDeviation")
	private Deviation deviation;
	
	@ManyToOne
	@JoinColumn(name="idApprovementGroup")
	private ApprovementGroup approvementGroup;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ApprovementGroup getApprovementGroup() {
		return approvementGroup;
	}
	public void setApprovementGroup(ApprovementGroup approvementGroup) {
		this.approvementGroup = approvementGroup;
	}
	public Deviation getDeviation() {
		return deviation;
	}
	public void setDeviation(Deviation deviation) {
		this.deviation = deviation;
	}
	public Long getIdApprovement() {
		return idApprovement;
	}
	public void setIdApprovement(Long idApprovement) {
		this.idApprovement = idApprovement;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public boolean isRejected() {
		return rejected;
	}
	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Approvement(boolean approved, boolean rejected, String comment,
			Date date) {
		super();
		this.approved = approved;
		this.rejected = rejected;
		this.comment = comment;
		this.date = date;
	}
	public Approvement(boolean approved, boolean rejected, String comment) {
		super();
		this.approved = approved;
		this.rejected = rejected;
		this.comment = comment;
	}
	public Approvement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
