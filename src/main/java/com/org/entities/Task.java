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
public class Task implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTask;
	
    private String taskName;
	private Date startDay;
	private Date endDate;
	private String status;      //status=(started, in progress, completed, deferred)
	private String category;     //(indicated with color value)
	private String priority;     //(Normal, ...)
	private int completed;       // in procent %
	private boolean reminder;
	
	@Lob
	private String content;
	
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;


	public Long getIdTask() {
		return idTask;
	}


	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}


	public Date getStartDay() {
		return startDay;
	}


	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public int getCompleted() {
		return completed;
	}


	public void setCompleted(int completed) {
		this.completed = completed;
	}


	public boolean isReminder() {
		return reminder;
	}


	public void setReminder(boolean reminder) {
		this.reminder = reminder;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}

	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public Task(String taskName, Date startDay, Date endDate, String status,
			String category, String priority, int completed, boolean reminder,
			String content) {
		super();
		this.taskName = taskName;
		this.startDay = startDay;
		this.endDate = endDate;
		this.status = status;
		this.category = category;
		this.priority = priority;
		this.completed = completed;
		this.reminder = reminder;
		this.content = content;
	}


	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		

}
