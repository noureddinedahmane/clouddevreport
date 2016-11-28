package com.org.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ClientPage implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClientPage;
	
	private String about;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Client client;
	
	@OneToMany(mappedBy="clientPage")
	private List<ClientService> clientServices;

	public Long getIdClientPage() {
		return idClientPage;
	}

	public void setIdClientPage(Long idClientPage) {
		this.idClientPage = idClientPage;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ClientService> getClientServices() {
		return clientServices;
	}

	public void setClientServices(List<ClientService> clientServices) {
		this.clientServices = clientServices;
	}

	public ClientPage(String about) {
		super();
		this.about = about;
	}

	public ClientPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
