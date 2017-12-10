package com.org.entities;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class Client implements UserDetails,Serializable {
    
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
	
	private boolean enabled = true;
	
	private String position;
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy="client")
	private List<Role> roles;
	
	@OneToMany(mappedBy="client")
	List<Historical> historicals ;
	 
	
	@ManyToOne
	@JoinColumn(name="idDomain")
	private Domain domain;
	
	@ManyToOne
	@JoinColumn(name="idAccount")
	private Account account;
	
	
	@OneToMany(mappedBy="client")
	List<UserApprovementGroup> userApprovementGroups ;
	
	@OneToMany(mappedBy="client")
	List<Approvement> approvements ;
	
	@OneToMany(mappedBy="client")
	List<Deviation> deviation ;
	
	@OneToMany(mappedBy="client")
	List<Domain> domains ;
	

	
	public List<Domain> getDomains() {
		return domains;
	}
	public void setDomains(List<Domain> domains) {
		this.domains = domains;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public List<Deviation> getDeviation() {
		return deviation;
	}
	public void setDeviation(List<Deviation> deviation) {
		this.deviation = deviation;
	}
	public List<Approvement> getApprovements() {
		return approvements;
	}
	public void setApprovements(List<Approvement> approvements) {
		this.approvements = approvements;
	}
	public List<UserApprovementGroup> getUserApprovementGroups() {
		return userApprovementGroups;
	}
	public void setUserApprovementGroups(
			List<UserApprovementGroup> userApprovementGroups) {
		this.userApprovementGroups = userApprovementGroups;
	}

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Historical> getHistoricals() {
		return historicals;
	}
	public void setHistoricals(List<Historical> historicals) {
		this.historicals = historicals;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	
	
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
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
	
	
	public Client(String name, String prenom, String username, String password,
			Date dateNaissance, boolean enabled, String position) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.enabled = enabled;
		this.position = position;
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
