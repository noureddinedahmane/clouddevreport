package com.org.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Client implements Serializable{
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	
	@NotEmpty(message="Please Enter Your Name")
	private String name;
	
	private String prenom;
	
	@NotEmpty(message="Please Enter Your Adresse Email")
	private String username;
	
	@NotEmpty(message="Please Enter Your PassWord")
	private String password;
	
	private Date dateNaissance;
	
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String name, String prenom, String username, String password,
			Date dateNaissance) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.dateNaissance = dateNaissance;
	}

	
	
}
