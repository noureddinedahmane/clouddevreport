package com.org.entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Client implements UserDetails {
    
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
	
	private boolean enabled=true;
	
	
	@OneToMany(mappedBy="client")
	private List<Note> notes;
	
	@OneToMany(mappedBy="client")
	private List<Patient> patients;
	
	@OneToMany(mappedBy="client")
	private List<Task> tasks;
	
	@OneToMany(mappedBy="client")
	private List<Calendar> calendars;
	
	

	
	public List<Calendar> getCalendars() {
		return calendars;
	}
	public void setCalendars(List<Calendar> calendars) {
		this.calendars = calendars;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
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
	
	public Client(Long idClient, String name, String prenom, String username,
			String password, Date dateNaissance) {
		super();
		this.idClient = idClient;
		this.name = name;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.dateNaissance = dateNaissance;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
