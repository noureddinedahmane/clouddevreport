package com.org.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.org.daoInter.IDaoClient;
import com.org.entities.Account;
import com.org.entities.Client;
import com.org.entities.Domain;
import com.org.entities.Role;

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



	@Override
	public Client getClientByUserName(String userName) {
		Query req = em.createQuery("select c from Client c where c.username=:x");
		req.setParameter("x", userName);
		
		List results = req.getResultList();
		
		if(!results.isEmpty()){
			
			return (Client)results.get(0);
		}else{
			
			return null;
		}
	}



	@Override
	public Role addRole(Client client, Role role) {
		 role.setClient(client);
		 em.persist(role);
		 
		return role;
	}



	@Override
	public Account addAccont(Account account) {
		em.persist(account);
		return account;
	}



	@Override
	public Account getAccount(Long id) {
		Account account = em.find(Account.class, id);
		return account;
	}



	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		if(account != null) {
			em.merge(account);
		}
		return account;
	}



	@Override
	public List<Client> listClientByAccount(Account account) {
		Query req = em.createQuery("select c from Client c where c.account=:x");
		req.setParameter("x", account);
		return req.getResultList();
	}



	@Override
	public List<Client> listUsersByDomain(Domain domain) {
		Query req = em.createQuery("select c from Client c where c.domain=:x");
		req.setParameter("x", domain);
		return req.getResultList();
	}



}
