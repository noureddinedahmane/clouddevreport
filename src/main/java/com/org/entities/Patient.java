package com.org.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Patient implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPatient;
	
	private String firstName;
	private String lastName;
	private String gender;
	private Date birthDay;
	private Date registrayDate;
	private String city;
	private String street;
	private String state;
	private String zipCode;
	private String homePhone;
	private String cellPhone;
	private String workPhone;
	private String emailAddress;
	private String occupation;
	private String irfchName;//icfchName= individual responsible for charges name
	private String irfchPhone;//icfchName= individual responsible for charges phone
	private String referredBy;
	private String referralReason;
	private String cphName; //cphName= currency phisician name
	private String cpPhone; //cphName= currency phisician phone
	
	
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	
	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public Date getRegistrayDate() {
		return registrayDate;
	}
	public void setRegistrayDate(Date registrayDate) {
		this.registrayDate = registrayDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getIrfchName() {
		return irfchName;
	}
	public void setIrfchName(String irfchName) {
		this.irfchName = irfchName;
	}
	public String getIrfchPhone() {
		return irfchPhone;
	}
	public void setIrfchPhone(String irfchPhone) {
		this.irfchPhone = irfchPhone;
	}
	public String getReferredBy() {
		return referredBy;
	}
	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}
	public String getReferralReason() {
		return referralReason;
	}
	public void setReferralReason(String referralReason) {
		this.referralReason = referralReason;
	}
	public String getCphName() {
		return cphName;
	}
	public void setCphName(String cphName) {
		this.cphName = cphName;
	}
	public String getCpPhone() {
		return cpPhone;
	}
	public void setCpPhone(String cpPhone) {
		this.cpPhone = cpPhone;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public Patient(String firstName, String lastName, String gender,
			Date birthDay, Date registrayDate, String city, String street,
			String state, String zipCode, String homePhone, String cellPhone,
			String workPhone, String emailAddress, String occupation,
			String irfchName, String irfchPhone, String referredBy,
			String referralReason, String cphName, String cpPhone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDay = birthDay;
		this.registrayDate = registrayDate;
		this.city = city;
		this.street = street;
		this.state = state;
		this.zipCode = zipCode;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.emailAddress = emailAddress;
		this.occupation = occupation;
		this.irfchName = irfchName;
		this.irfchPhone = irfchPhone;
		this.referredBy = referredBy;
		this.referralReason = referralReason;
		this.cphName = cphName;
		this.cpPhone = cpPhone;
	}
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
