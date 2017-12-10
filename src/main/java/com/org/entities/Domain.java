package com.org.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Domain implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDomain;
	
	private String domainName;
	private Date dateCreation;
	private String others;
	
	@OneToMany(mappedBy="domain")
	List<Client> clients ;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "domain", cascade = CascadeType.ALL)
	private Configuration configuration;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="idAccount")
	private Account account;
	
	@OneToMany(mappedBy="domain")
	List<ApprovementGroup> approvementGroups;
	
	@OneToMany(mappedBy="domain")
	List<DeviationType> deviationTypes;
	
	

	public List<DeviationType> getDeviationTypes() {
		return deviationTypes;
	}
	public void setDeviationTypes(List<DeviationType> deviationTypes) {
		this.deviationTypes = deviationTypes;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	public Long getIdDomain() {
		return idDomain;
	}
	public void setIdDomain(Long idDomain) {
		this.idDomain = idDomain;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public List<ApprovementGroup> getApprovementGroups() {
		return approvementGroups;
	}
	public void setApprovementGroups(List<ApprovementGroup> approvementGroups) {
		this.approvementGroups = approvementGroups;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Domain(String domainName, Date dateCreation, String others) {
		super();
		this.domainName = domainName;
		this.dateCreation = dateCreation;
		this.others = others;
	}
	public Domain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
