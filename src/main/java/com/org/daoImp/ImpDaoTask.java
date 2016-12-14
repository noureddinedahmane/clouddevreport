package com.org.daoImp;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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
			if(task.getClient().getIdClient().equals(client.getIdClient())){
				
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
			
			if(task.getClient().getIdClient().equals(client.getIdClient())){
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
	
		if(task!=null){
			task.setClient(client);
			em.merge(task);
		}
		
		return task;
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

		 Criteria  criteria = em.unwrap(Session.class).createCriteria(Task.class);
		 criteria.add(Restrictions.eq("taskName", taskName));
		 criteria.add(Restrictions.eq("client", client));
		 
		 criteria.setFirstResult(min);
		 criteria.setMaxResults(max);
		 
		return criteria.list();
	}

	@Override
	public List<Task> searchTaskByBodyMotif(int min, int max, String bodyMotif,
			Client client) {
		
		 Criteria  criteria = em.unwrap(Session.class).createCriteria(Task.class);
		 criteria.add(Restrictions.like("content", bodyMotif, MatchMode.ANYWHERE));
		 criteria.add(Restrictions.eq("client", client));
		 
		 criteria.setFirstResult(min);
		 criteria.setMaxResults(max);
		 
		return criteria.list();
	}

	@Override
	public List<Task> filterTask(int min, int max, Date startDay, Date endDate,
			String status, String category, String priority, Client client) {
		
		 Criteria  criteria = em.unwrap(Session.class).createCriteria(Task.class);
		 criteria.add(Restrictions.eq("client",client));
		 
		 if(startDay!=null){
			 criteria.add(Restrictions.eq("startDay", startDay));
		 }
		 if(endDate!=null){
			 criteria.add(Restrictions.eq("endDate", endDate));
		 }
		 if(status!=null){
			 criteria.add(Restrictions.eq("status", status));
		 }
		 if(category!=null){
			 criteria.add(Restrictions.eq("category", category));
		 }
		 if(priority!=null){
			 criteria.add(Restrictions.eq("priority", priority));
		 }
		
		 criteria.setFirstResult(min);
		 criteria.setMaxResults(max);
		 
		return criteria.list();
	}

}
