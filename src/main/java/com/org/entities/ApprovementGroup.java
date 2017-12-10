package com.org.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ApprovementGroup implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idApprovementGroup;
	
	private String label;
	private String role;//should be unique
	private Date dateCreation;
	private String listEmail;// list of emails or an emailverteiler
	
	@OneToMany(mappedBy="approvementGroup")
    List<Approvement> aprovements ;
	
	@OneToMany(mappedBy="approvementGroup")
	List<UserApprovementGroup> userApprovementGroups ;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="idDomain")
	private Domain domain;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<UserApprovementGroup> getUserApprovementGroups() {
		return userApprovementGroups;
	}
	public void setUserApprovementGroups(
			List<UserApprovementGroup> userApprovementGroups) {
		this.userApprovementGroups = userApprovementGroups;
	}
	public List<Approvement> getAprovements() {
		return aprovements;
	}
	public void setAprovements(List<Approvement> aprovements) {
		this.aprovements = aprovements;
	}
	public Long getIdApprovementGroup() {
		return idApprovementGroup;
	}
	public void setIdApprovementGroup(Long idApprovementGroup) {
		this.idApprovementGroup = idApprovementGroup;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getListEmail() {
		return listEmail;
	}
	public void setListEmail(String listEmail) {
		this.listEmail = listEmail;
	}
	
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public ApprovementGroup(String label, String role, Date dateCreation,
			String listEmail) {
		super();
		this.label = label;
		this.role = role;
		this.dateCreation = dateCreation;
		this.listEmail = listEmail;
	}
	public ApprovementGroup(String label, String role, String listEmail) {
		super();
		this.label = label;
		this.role = role;
		this.listEmail = listEmail;
	}
	public ApprovementGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
