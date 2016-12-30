package com.org.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Regime implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRegime;
	
	private String matinLUN;
	private String mediLUN;
	private String soirLUN;
	
	private String matinMAR;
	private String mediMAR;
	private String soirMAR;
	
	private String matinMER;
	private String mediMER;
	private String soirMER;
	
	private String matinJEU;
	private String mediJEU;
	private String soirJEU;
	
	private String matinVEN;
	private String mediVEN;
	private String soirVEN;
	
	private String matinSAM;
	private String mediSAM;
	private String soirSAM;
	
	private String matinDEM;
	private String mediDEM;
	private String soirDEM;
	
	private String note;
	private String title;
	private Date lastUpdate;
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name="idPatient")
	private Patient patient;
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Long getIdRegime() {
		return idRegime;
	}
	public void setIdRegime(Long idRegime) {
		this.idRegime = idRegime;
	}
	public String getMatinLUN() {
		return matinLUN;
	}
	public void setMatinLUN(String matinLUN) {
		this.matinLUN = matinLUN;
	}
	public String getMediLUN() {
		return mediLUN;
	}
	public void setMediLUN(String mediLUN) {
		this.mediLUN = mediLUN;
	}
	public String getSoirLUN() {
		return soirLUN;
	}
	public void setSoirLUN(String soirLUN) {
		this.soirLUN = soirLUN;
	}
	public String getMatinMAR() {
		return matinMAR;
	}
	public void setMatinMAR(String matinMAR) {
		this.matinMAR = matinMAR;
	}
	public String getMediMAR() {
		return mediMAR;
	}
	public void setMediMAR(String mediMAR) {
		this.mediMAR = mediMAR;
	}
	public String getSoirMAR() {
		return soirMAR;
	}
	public void setSoirMAR(String soirMAR) {
		this.soirMAR = soirMAR;
	}
	public String getMatinMER() {
		return matinMER;
	}
	public void setMatinMER(String matinMER) {
		this.matinMER = matinMER;
	}
	public String getMediMER() {
		return mediMER;
	}
	public void setMediMER(String mediMER) {
		this.mediMER = mediMER;
	}
	public String getSoirMER() {
		return soirMER;
	}
	public void setSoirMER(String soirMER) {
		this.soirMER = soirMER;
	}
	public String getMatinJEU() {
		return matinJEU;
	}
	public void setMatinJEU(String matinJEU) {
		this.matinJEU = matinJEU;
	}
	public String getMediJEU() {
		return mediJEU;
	}
	public void setMediJEU(String mediJEU) {
		this.mediJEU = mediJEU;
	}
	public String getSoirJEU() {
		return soirJEU;
	}
	public void setSoirJEU(String soirJEU) {
		this.soirJEU = soirJEU;
	}
	public String getMatinVEN() {
		return matinVEN;
	}
	public void setMatinVEN(String matinVEN) {
		this.matinVEN = matinVEN;
	}
	public String getMediVEN() {
		return mediVEN;
	}
	public void setMediVEN(String mediVEN) {
		this.mediVEN = mediVEN;
	}
	public String getSoirVEN() {
		return soirVEN;
	}
	public void setSoirVEN(String soirVEN) {
		this.soirVEN = soirVEN;
	}
	public String getMatinSAM() {
		return matinSAM;
	}
	public void setMatinSAM(String matinSAM) {
		this.matinSAM = matinSAM;
	}
	public String getMediSAM() {
		return mediSAM;
	}
	public void setMediSAM(String mediSAM) {
		this.mediSAM = mediSAM;
	}
	public String getSoirSAM() {
		return soirSAM;
	}
	public void setSoirSAM(String soirSAM) {
		this.soirSAM = soirSAM;
	}
	public String getMatinDEM() {
		return matinDEM;
	}
	public void setMatinDEM(String matinDEM) {
		this.matinDEM = matinDEM;
	}
	public String getMediDEM() {
		return mediDEM;
	}
	public void setMediDEM(String mediDEM) {
		this.mediDEM = mediDEM;
	}
	public String getSoirDEM() {
		return soirDEM;
	}
	public void setSoirDEM(String soirDEM) {
		this.soirDEM = soirDEM;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public Regime(String matinLUN, String mediLUN, String soirLUN,
			String matinMAR, String mediMAR, String soirMAR, String matinMER,
			String mediMER, String soirMER, String matinJEU, String mediJEU,
			String soirJEU, String matinVEN, String mediVEN, String soirVEN,
			String matinSAM, String mediSAM, String soirSAM, String matinDEM,
			String mediDEM, String soirDEM, String note, String title,
			Date lastUpdate, boolean active) {
		super();
		this.matinLUN = matinLUN;
		this.mediLUN = mediLUN;
		this.soirLUN = soirLUN;
		this.matinMAR = matinMAR;
		this.mediMAR = mediMAR;
		this.soirMAR = soirMAR;
		this.matinMER = matinMER;
		this.mediMER = mediMER;
		this.soirMER = soirMER;
		this.matinJEU = matinJEU;
		this.mediJEU = mediJEU;
		this.soirJEU = soirJEU;
		this.matinVEN = matinVEN;
		this.mediVEN = mediVEN;
		this.soirVEN = soirVEN;
		this.matinSAM = matinSAM;
		this.mediSAM = mediSAM;
		this.soirSAM = soirSAM;
		this.matinDEM = matinDEM;
		this.mediDEM = mediDEM;
		this.soirDEM = soirDEM;
		this.note = note;
		this.title = title;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}
	public Regime() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
