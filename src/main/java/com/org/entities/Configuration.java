
/*
 * This class is giving metadata about validating the deviation input that cab configuered by the user
 * the user should  havethe role ROLE_ADMIN_DOMAIN to be able to change this object
 * 
 */
package com.org.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Configuration implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idValidation;
	
	//deviation inputs validation patterns
	private boolean deviationRef;
    private boolean deviationRiskCategory;
    private boolean requestedBy;
    private boolean dateCreation;
    private boolean signature;
    private boolean position;
    private boolean deviationType;
    private boolean sollZustand;
    private boolean istZustand;
    private boolean startDatePeriod;
    private boolean endDatePeriod;
    private boolean dateClosed;
    private boolean product;
    private boolean anlage;
    private boolean barcode;
    
    //define the prefix of the deviationRef ex: deviationRef="prefix_01"
    private String deviationRefPrefix;

    @OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Domain domain;
    
    
	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Long getIdValidation() {
		return idValidation;
	}

	public void setIdValidation(Long idValidation) {
		this.idValidation = idValidation;
	}

	public boolean isDeviationRef() {
		return deviationRef;
	}

	public void setDeviationRef(boolean deviationRef) {
		this.deviationRef = deviationRef;
	}

	public boolean isDeviationRiskCategory() {
		return deviationRiskCategory;
	}

	public void setDeviationRiskCategory(boolean deviationRiskCategory) {
		this.deviationRiskCategory = deviationRiskCategory;
	}

	public boolean isRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(boolean requestedBy) {
		this.requestedBy = requestedBy;
	}

	public boolean isDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(boolean dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean isSignature() {
		return signature;
	}

	public void setSignature(boolean signature) {
		this.signature = signature;
	}

	public boolean isPosition() {
		return position;
	}

	public void setPosition(boolean position) {
		this.position = position;
	}

	public boolean isDeviationType() {
		return deviationType;
	}

	public void setDeviationType(boolean deviationType) {
		this.deviationType = deviationType;
	}

	public boolean isSollZustand() {
		return sollZustand;
	}

	public void setSollZustand(boolean sollZustand) {
		this.sollZustand = sollZustand;
	}

	public boolean isIstZustand() {
		return istZustand;
	}

	public void setIstZustand(boolean istZustand) {
		this.istZustand = istZustand;
	}

	public boolean isStartDatePeriod() {
		return startDatePeriod;
	}

	public void setStartDatePeriod(boolean startDatePeriod) {
		this.startDatePeriod = startDatePeriod;
	}

	public boolean isEndDatePeriod() {
		return endDatePeriod;
	}

	public void setEndDatePeriod(boolean endDatePeriod) {
		this.endDatePeriod = endDatePeriod;
	}

	public boolean isDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(boolean dateClosed) {
		this.dateClosed = dateClosed;
	}

	public boolean isProduct() {
		return product;
	}

	public void setProduct(boolean product) {
		this.product = product;
	}

	public boolean isAnlage() {
		return anlage;
	}

	public void setAnlage(boolean anlage) {
		this.anlage = anlage;
	}

	public boolean isBarcode() {
		return barcode;
	}

	public void setBarcode(boolean barcode) {
		this.barcode = barcode;
	}

	public String getDeviationRefPrefix() {
		return deviationRefPrefix;
	}

	public void setDeviationRefPrefix(String deviationRefPrefix) {
		this.deviationRefPrefix = deviationRefPrefix;
	}

	public Configuration(boolean deviationRef, boolean deviationRiskCategory,
			boolean requestedBy, boolean dateCreation, boolean signature,
			boolean position, boolean deviationType, boolean sollZustand,
			boolean istZustand, boolean startDatePeriod, boolean endDatePeriod,
			boolean dateClosed, boolean product, boolean anlage,
			boolean barcode, String deviationRefPrefix) {
		super();
		this.deviationRef = deviationRef;
		this.deviationRiskCategory = deviationRiskCategory;
		this.requestedBy = requestedBy;
		this.dateCreation = dateCreation;
		this.signature = signature;
		this.position = position;
		this.deviationType = deviationType;
		this.sollZustand = sollZustand;
		this.istZustand = istZustand;
		this.startDatePeriod = startDatePeriod;
		this.endDatePeriod = endDatePeriod;
		this.dateClosed = dateClosed;
		this.product = product;
		this.anlage = anlage;
		this.barcode = barcode;
		this.deviationRefPrefix = deviationRefPrefix;
	}

	public Configuration() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
}
