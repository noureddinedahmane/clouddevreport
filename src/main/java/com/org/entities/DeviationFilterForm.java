package com.org.entities;

import java.io.Serializable;
import java.util.Date;

public class DeviationFilterForm implements Serializable{

	private String deviationRef;
	private String anlage;
	private String product;
	private String deviationType;
	private Date startDate;
	private Date endDate;
	
	public String getDeviationRef() {
		return deviationRef;
	}
	public void setDeviationRef(String deviationRef) {
		this.deviationRef = deviationRef;
	}
	public String getAnlage() {
		return anlage;
	}
	public void setAnlage(String anlage) {
		this.anlage = anlage;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDeviationType() {
		return deviationType;
	}
	public void setDeviationType(String deviationType) {
		this.deviationType = deviationType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public DeviationFilterForm(String deviationRef, String anlage, String product, String deviationType, Date startDate,
			Date endDate) {
		super();
		this.deviationRef = deviationRef;
		this.anlage = anlage;
		this.product = product;
		this.deviationType = deviationType;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public DeviationFilterForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
