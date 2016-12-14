package com.org.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Profile implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProfile;
	
	private String clientFirstName;
	private String clientLatName;
	private String clientTitle;
	private Date clientBirthDay;
	private Date clientProfileLastUpdate;
	private String clientEmail;
	private String clientPhone;
	private String clientMobilePhone;
	private String clientFaceBookPage;
	private String clientTwitterPage;
	private String clientCity;
	private String clientContry;
	private String clientSreet;
	private String clientHouseNumber;
	
	@Lob
	private String clientDescription;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Client client;

	
	
	public Date getClientProfileLastUpdate() {
		return clientProfileLastUpdate;
	}

	public void setClientProfileLastUpdate(Date clientProfileLastUpdate) {
		this.clientProfileLastUpdate = clientProfileLastUpdate;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientLatName() {
		return clientLatName;
	}

	public void setClientLatName(String clientLatName) {
		this.clientLatName = clientLatName;
	}

	public String getClientTitle() {
		return clientTitle;
	}

	public void setClientTitle(String clientTitle) {
		this.clientTitle = clientTitle;
	}

	public Date getClientBirthDay() {
		return clientBirthDay;
	}

	public void setClientBirthDay(Date clientBirthDay) {
		this.clientBirthDay = clientBirthDay;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientMobilePhone() {
		return clientMobilePhone;
	}

	public void setClientMobilePhone(String clientMobilePhone) {
		this.clientMobilePhone = clientMobilePhone;
	}

	public String getClientFaceBookPage() {
		return clientFaceBookPage;
	}

	public void setClientFaceBookPage(String clientFaceBookPage) {
		this.clientFaceBookPage = clientFaceBookPage;
	}

	public String getClientTwitterPage() {
		return clientTwitterPage;
	}

	public void setClientTwitterPage(String clientTwitterPage) {
		this.clientTwitterPage = clientTwitterPage;
	}

	public String getClientCity() {
		return clientCity;
	}

	public void setClientCity(String clientCity) {
		this.clientCity = clientCity;
	}

	public String getClientContry() {
		return clientContry;
	}

	public void setClientContry(String clientContry) {
		this.clientContry = clientContry;
	}

	public String getClientSreet() {
		return clientSreet;
	}

	public void setClientSreet(String clientSreet) {
		this.clientSreet = clientSreet;
	}

	public String getClientHouseNumber() {
		return clientHouseNumber;
	}

	public void setClientHouseNumber(String clientHouseNumber) {
		this.clientHouseNumber = clientHouseNumber;
	}

	public String getClientDescription() {
		return clientDescription;
	}

	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}
	

	public Long getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Long idProfile) {
		this.idProfile = idProfile;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Profile(String clientFirstName, String clientLatName, String clientTitle, Date clientBirthDay,
			Date clientProfileLastUpdate, String clientEmail, String clientPhone, String clientMobilePhone,
			String clientFaceBookPage, String clientTwitterPage, String clientCity, String clientContry,
			String clientSreet, String clientHouseNumber, String clientDescription) {
		super();
		this.clientFirstName = clientFirstName;
		this.clientLatName = clientLatName;
		this.clientTitle = clientTitle;
		this.clientBirthDay = clientBirthDay;
		this.clientProfileLastUpdate = clientProfileLastUpdate;
		this.clientEmail = clientEmail;
		this.clientPhone = clientPhone;
		this.clientMobilePhone = clientMobilePhone;
		this.clientFaceBookPage = clientFaceBookPage;
		this.clientTwitterPage = clientTwitterPage;
		this.clientCity = clientCity;
		this.clientContry = clientContry;
		this.clientSreet = clientSreet;
		this.clientHouseNumber = clientHouseNumber;
		this.clientDescription = clientDescription;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
