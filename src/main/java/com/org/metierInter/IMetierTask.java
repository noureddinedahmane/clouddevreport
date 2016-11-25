package com.org.metierInter;

import java.util.Date;
import java.util.List;

import com.org.entities.Client;
import com.org.entities.Task;

public interface IMetierTask {
	
	public Task addTask(Task task, Client client);
	public Task getTask(Long idTask, Client client);
	public boolean deleteTask(Long idTask, Client client);
	public Task updateTask(Task task, Client client);
	public List<Task> listTasks(int min, int max, Client client);
	public List<Task> searchTaskByTaskName(int min, int max, String taskName, Client client);
	public List<Task> searchTaskByBodyMotif(int min, int max, String bodyMotif, Client client);
    public List<Task> filterTask(int min, int max, Date startDay, Date endDate,
    		                     String status, String category, String priority, Client client);	
	

}
