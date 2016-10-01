package com.org.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.org.daoInter.IDaoClient;
import com.org.entities.Client;

public class ImpDaoClient implements IDaoClient{

    @PersistenceContext
	private EntityManager em;
    
    
    
	@Override
	public Client addClient(Client client) {
		em.persist(client);
		return client;
	}



	@Override
	public Client getClient(Long id) {
		Client client = em.find(Client.class, id);
		return client;
	}



	@Override
	public void deleteClient(Long id) {
	    Client client =  em.find(Client.class, id);
	    if(client!=null){
	      em.remove(client);
	    }
	}



	@Override
	public Client updateClient(Client client) {
		 if(client!=null){
			 em.merge(client);
		 }
		return client;
	}



	@Override
	public List<Client> listAllClients() {
		Query req = em.createQuery("select c from Client c");
		return req.getResultList();
	}

}
