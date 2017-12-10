package com.org.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DeviationType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDeviationType;
	
	private String deviationType;
	
	@ManyToOne
	@JoinColumn(name="idDomain")
	private Domain domain;

	public Long getIdDeviationType() {
		return idDeviationType;
	}

	public void setIdDeviationType(Long idDeviationType) {
		this.idDeviationType = idDeviationType;
	}

	public String getDeviationType() {
		return deviationType;
	}

	public void setDeviationType(String deviationType) {
		this.deviationType = deviationType;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public DeviationType(Long idDeviationType, String deviationType) {
		super();
		this.idDeviationType = idDeviationType;
		this.deviationType = deviationType;
	}

	public DeviationType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
