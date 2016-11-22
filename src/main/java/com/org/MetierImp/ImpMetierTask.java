package com.org.MetierImp;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoTask;
import com.org.entities.Client;
import com.org.entities.Task;
import com.org.metierInter.IMetierTask;

@Transactional
public class ImpMetierTask implements IMetierTask{

	private IDaoTask daoTask;
	
	public IDaoTask getDaoTask() {
		return daoTask;
	}

	public void setDaoTask(IDaoTask daoTask) {
		this.daoTask = daoTask;
	}

	@Override
	public Task addTask(Task task, Client client) {
		return daoTask.addTask(task, client);
	}

	@Override
	public Task getTask(Long idTask, Client client) {
		return daoTask.getTask(idTask, client);
	}

	@Override
	public boolean deleteTask(Long idTask, Client client) {
		return daoTask.deleteTask(idTask, client);
	}

	@Override
	public Task updateTask(Task task, Client client) {
		return daoTask.updateTask(task, client);
	}

	@Override
	public List<Task> listTasks(int min, int max, Client client) {
		return daoTask.listTasks(min, max, client);
	}

	@Override
	public List<Task> searchTaskByTaskName(int min, int max, String taskName,
			Client client) {
		return daoTask.searchTaskByTaskName(min, max, taskName, client);
	}

	@Override
	public List<Task> searchTaskByBodyMotif(int min, int max, String bodyMotif,
			Client client) {
		return daoTask.searchTaskByBodyMotif(min, max, bodyMotif, client);
	}

	@Override
	public List<Task> filterTask(int min, int max, Date startDay, Date endDate,
			String status, String category, String priority) {
		return daoTask.filterTask(min, max, startDay, endDate, status, category, priority);
	}

}
