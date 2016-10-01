package com.org.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client implements Serializable{
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	
	private String name;
	private String prenom;
	private String email;
	private String passWord;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String name, String prenom, String email, String passWord,
			Date dateNaissance) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.email = email;
		this.passWord = passWord;
		this.dateNaissance = dateNaissance;
	}
	
	
	
}
