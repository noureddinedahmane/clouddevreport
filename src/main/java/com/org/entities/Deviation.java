package com.org.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Deviation implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDeviation;
	
    private String deviationRef;
    private String deviationRiskCategory;
    private String requestedBy;
    private Date dateCreation;
    private String signature;
    private String position;
    private String deviationType;
    private String deviationTypeOther;
    private String sollZustand;
    private String istZustand;
    private Date startDatePeriod;
    private Date endDatePeriod;
    private Date dateClosed;
    private String product;
    private String anlage;
    private String barcode;
    private String reason1;
    private String reason2;
    private String reason3;
    private String reason4;
    private String reason5;
    

	@Transient
	private String status;
    
    @OneToMany(mappedBy="deviation")
    List<Attachement> attachements;
    
    @OneToMany(mappedBy="deviation")
    List<Historical> historicals ;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="deviation")
    @Fetch(value = FetchMode.SUBSELECT)
    List<Approvement> aprovements ;
    
    @ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
    
    @ManyToOne
	@JoinColumn(name="idDomain")
	private Domain domain;
    
    
    
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Approvement> getAprovements() {
		return aprovements;
	}
	public void setAprovements(List<Approvement> aprovements) {
		this.aprovements = aprovements;
	}
	public List<Historical> getHistoricals() {
		return historicals;
	}
	public void setHistoricals(List<Historical> historicals) {
		this.historicals = historicals;
	}
	public List<Attachement> getAttachements() {
		return attachements;
	}
	public void setAttachements(List<Attachement> attachements) {
		this.attachements = attachements;
	}
	public String getReason1() {
		return reason1;
	}
	public void setReason1(String reason1) {
		this.reason1 = reason1;
	}
	public String getReason2() {
		return reason2;
	}
	public void setReason2(String reason2) {
		this.reason2 = reason2;
	}
	public String getReason3() {
		return reason3;
	}
	public void setReason3(String reason3) {
		this.reason3 = reason3;
	}
	public String getReason4() {
		return reason4;
	}
	public void setReason4(String reason4) {
		this.reason4 = reason4;
	}
	public String getReason5() {
		return reason5;
	}
	public void setReason5(String reason5) {
		this.reason5 = reason5;
	}
	public Long getIdDeviation() {
		return idDeviation;
	}
	public void setIdDeviation(Long idDeviation) {
		this.idDeviation = idDeviation;
	}
	public String getDeviationRef() {
		return deviationRef;
	}
	public void setDeviationRef(String deviationRef) {
		this.deviationRef = deviationRef;
	}
	public String getDeviationRiskCategory() {
		return deviationRiskCategory;
	}
	public void setDeviationRiskCategory(String deviationRiskCategory) {
		this.deviationRiskCategory = deviationRiskCategory;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDeviationType() {
		return deviationType;
	}
	public void setDeviationType(String deviationType) {
		this.deviationType = deviationType;
	}
	public String getSollZustand() {
		return sollZustand;
	}
	public void setSollZustand(String sollZustand) {
		this.sollZustand = sollZustand;
	}
	public String getIstZustand() {
		return istZustand;
	}
	public void setIstZustand(String istZustand) {
		this.istZustand = istZustand;
	}
	public Date getStartDatePeriod() {
		return startDatePeriod;
	}
	public void setStartDatePeriod(Date startDatePeriod) {
		this.startDatePeriod = startDatePeriod;
	}
	public Date getEndDatePeriod() {
		return endDatePeriod;
	}
	public void setEndDatePeriod(Date endDatePeriod) {
		this.endDatePeriod = endDatePeriod;
	}
	public Date getDateClosed() {
		return dateClosed;
	}
	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getAnlage() {
		return anlage;
	}
	public void setAnlage(String anlage) {
		this.anlage = anlage;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	
	public String getDeviationTypeOther() {
		return deviationTypeOther;
	}
	public void setDeviationTypeOther(String deviationTypeOther) {
		this.deviationTypeOther = deviationTypeOther;
	}
	
	public Deviation(Long idDeviation, String deviationRef, String deviationRiskCategory, String requestedBy,
			Date dateCreation, String signature, String position, String deviationType, String deviationTypeOther,
			String sollZustand, String istZustand, Date startDatePeriod, Date endDatePeriod, Date dateClosed,
			String product, String anlage, String barcode, String reason1, String reason2, String reason3,
			String reason4, String reason5) {
		super();
		this.idDeviation = idDeviation;
		this.deviationRef = deviationRef;
		this.deviationRiskCategory = deviationRiskCategory;
		this.requestedBy = requestedBy;
		this.dateCreation = dateCreation;
		this.signature = signature;
		this.position = position;
		this.deviationType = deviationType;
		this.deviationTypeOther = deviationTypeOther;
		this.sollZustand = sollZustand;
		this.istZustand = istZustand;
		this.startDatePeriod = startDatePeriod;
		this.endDatePeriod = endDatePeriod;
		this.dateClosed = dateClosed;
		this.product = product;
		this.anlage = anlage;
		this.barcode = barcode;
		this.reason1 = reason1;
		this.reason2 = reason2;
		this.reason3 = reason3;
		this.reason4 = reason4;
		this.reason5 = reason5;
	}
	public Deviation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//get the status of a deviation
	public String getStatus() {
		String devStatus = "";
		List<Approvement> approvements = this.getAprovements();
		
		
		boolean isApproved = true;
		boolean isRejected = false;
		
		for(Approvement approvement: approvements) {
			if(approvement.isRejected()) {
				isRejected = true;
				break;
			}
		}
		
		if(!isRejected) {
			//if not rejected , make see id its approved
			for(Approvement approvement: approvements) {
				if(!approvement.isApproved()) {
					isApproved = false;
					break;
				}
			}
		}
		
		
		if(isRejected) {
			devStatus = "rejected";
		}else {
			if(isApproved) {
				devStatus = "approved";
			}else {
				// if not rejected and not approved --> expired  or pending
				
				if(this.getEndDatePeriod() != null) {
					if(new Date().after(this.getEndDatePeriod())) {
						devStatus = "expired";
					}else {
						devStatus = "pendding";
					}
				}else {
					devStatus = "pendding";
				}
				
			}
		}
		
		return devStatus;
	}
    
   
    
}
