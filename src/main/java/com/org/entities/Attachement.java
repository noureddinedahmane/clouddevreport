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
public class Attachement implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAttachement;
	
	private String fileName;
	private String fileDBName;
	private String label;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="idDeviation")
	private Deviation deviation;
	
	
	public Deviation getDeviation() {
		return deviation;
	}
	public void setDeviation(Deviation deviation) {
		this.deviation = deviation;
	}
	public Long getIdAttachement() {
		return idAttachement;
	}
	public void setIdAttachement(Long idAttachement) {
		this.idAttachement = idAttachement;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDBName() {
		return fileDBName;
	}
	public void setFileDBName(String fileDBName) {
		this.fileDBName = fileDBName;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Attachement(String fileName, String fileDBName, String label,
			Date date) {
		super();
		this.fileName = fileName;
		this.fileDBName = fileDBName;
		this.label = label;
		this.date = date;
	}
	public Attachement(String fileName, String fileDBName, String label) {
		super();
		this.fileName = fileName;
		this.fileDBName = fileDBName;
		this.label = label;
	}
	public Attachement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
