package com.org.daoImp;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.org.daoInter.IDaoTask;
import com.org.entities.Client;
import com.org.entities.Task;

public class ImpDaoTask implements IDaoTask{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Task addTask(Task task, Client client) {
		
		task.setClient(client);
		em.persist(task);
		
		return task;
	}

	@Override
	public Task getTask(Long idTask, Client client) {
		
		Task task = em.find(Task.class,idTask);
		
		if(task!=null){
			if(task.getClient().equals(client)){
				
				return task;
			}else{
				return null;
			}
		}else{
			return null;
		}
		
	}

	@Override
	public boolean deleteTask(Long idTask, Client client) {
		
		Task task = em.find(Task.class,idTask);
		if(task!=null){
			
			if(task.getClient().equals(client)){
				em.remove(task);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public Task updateTask(Task task, Client client) {
		
		if(task.getClient().equals(client)){
			
			em.merge(task);
			return task;
		}else{
			return null;
		}
	}

	@Override
	public List<Task> listTasks(int min, int max, Client client) {
		
		Query req = em.createQuery("select t from Task t where t.client=:c");
		req.setParameter("c", client);
		req.setFirstResult(min);
		req.setMaxResults(max);
		
		return req.getResultList();
	}

	@Override
	public List<Task> searchTaskByTaskName(int min, int max, String taskName,
			Client client) {

		return null;
	}

	@Override
	public List<Task> searchTaskByBodyMotif(int min, int max, String bodyMotif,
			Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> filterTask(int min, int max, Date startDay, Date endDate,
			String status, String category, String priority) {
		// TODO Auto-generated method stub
		return null;
	}

}
