package com.org.daoImp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.org.daoInter.IDaoClient;
import com.org.entities.Client;

public class ImpDaoClient implements IDaoClient{

    @PersistenceContext
	private EntityManager em;
    
    
    
	@Override
	public Client addClient(Client client) {
		// TODO Auto-generated method stub
		em.persist(client);
		
		return client;
	}

}
