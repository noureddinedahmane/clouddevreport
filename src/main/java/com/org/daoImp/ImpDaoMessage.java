package com.org.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.org.daoInter.IDaoMessage;
import com.org.entities.Client;
import com.org.entities.Message;

public class ImpDaoMessage implements IDaoMessage{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Message addMessage(Message message, Client client) {
		  message.setClient(client);
		  em.persist(message);
		  
		  return message;
	}

	@Override
	public Message getMessage(Long idMessage, Client client) {
		Message message = em.find(Message.class, idMessage);
		if(message!=null){
			if(message.getClient().equals(client)){
				return message;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public Message updateMessage(Message message, Client client) {
		message.setClient(client);
		em.merge(message);
		
		return message;
	}

	@Override
	public boolean deleteMessage(Long idMessage, Client client) {
		Message message = em.find(Message.class, idMessage);
		if(message!=null){
			if(message.getClient().equals(client)){
				em.remove(message);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public List<Message> listMessages(int min, int max, Client client) {
		
		Query req = em.createQuery("select m from Message m where m.client=:c");
		req.setParameter("c", client);
		req.setFirstResult(min);
		req.setMaxResults(max);
		
		return req.getResultList();
	}

	@Override
	public List<Message> searchMessages(int min, int max, String subject,
			String email, String name, Client client) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
