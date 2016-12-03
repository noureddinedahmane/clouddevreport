package com.org.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.org.daoInter.IDaoClientPage;
import com.org.entities.Client;
import com.org.entities.ClientPage;
import com.org.entities.ClientService;
import com.org.entities.ImageHero;

public class ImpDaoClientPage implements IDaoClientPage{

	 @PersistenceContext
	 private EntityManager em;
	 
	 
	@Override
	public ClientPage createClientPage(Client client) {
		ClientPage clientPage = new ClientPage();
		clientPage.setClient(client);
		em.persist(clientPage);
		
		return clientPage;
	}

	@Override
	public ClientPage updateAboutClientPage(String about, Client client) {
		
		ClientPage clientPage = client.getClientPage();
		clientPage.setAbout(about);
	    em.merge(clientPage);
	    
		return clientPage;
	}

	@Override
	public ClientPage updateImageHeroClientPage(List<ImageHero> imageHero, Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientService addClientService(ClientService clientService,
			Client client) {
		
		ClientPage clientPage = client.getClientPage();
		clientService.setClientPage(clientPage);
	    em.persist(clientService);
	    
		return clientService;
	}
	

	@Override
	public ClientService updateClientService(ClientService clientService,
			Client client) {
		
		ClientPage clientPage = client.getClientPage();
		clientService.setClientPage(clientPage);
		em.merge(clientService);
		
		return clientService;
	}
	

	@Override
	public boolean deleteClientService(Long idClientService, Client client) {
		
		ClientService clientService = em.find(ClientService.class, idClientService);
		if(clientService!=null){
			if(client.getIdClient()==clientService.getClientPage().getClient().getIdClient()){
				em.remove(clientService);
				return true;
			}
			else{
				return false;
			}
		}else{
			return false;
		}
	}
	

	@Override
	public ClientService getClientService(Long idClientService, Client client) {
		
		ClientService clientService = em.find(ClientService.class, idClientService);
		if(client.getIdClient()==clientService.getClientPage().getClient().getIdClient()){
			return clientService;	
		}
		else{
			return null;
		}

	}

}
