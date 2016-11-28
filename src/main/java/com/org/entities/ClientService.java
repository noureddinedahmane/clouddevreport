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
public class ClientService implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClientService;
	
	private String serviceName;
	private String serviceDescription;
	private Date dateCreation;
	private Date dateLastUpdate;
	
	@ManyToOne
	@JoinColumn(name="idClientPage")
	private ClientPage clientPage;

	public Long getIdClientService() {
		return idClientService;
	}

	public void setIdClientService(Long idClientService) {
		this.idClientService = idClientService;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateLastUpdate() {
		return dateLastUpdate;
	}

	public void setDateLastUpdate(Date dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
	}

	public ClientPage getClientPage() {
		return clientPage;
	}

	public void setClientPage(ClientPage clientPage) {
		this.clientPage = clientPage;
	}

	public ClientService(String serviceName, String serviceDescription,
			Date dateCreation, Date dateLastUpdate) {
		super();
		this.serviceName = serviceName;
		this.serviceDescription = serviceDescription;
		this.dateCreation = dateCreation;
		this.dateLastUpdate = dateLastUpdate;
	}

	public ClientService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
