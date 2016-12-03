package com.org.daoInter;

import java.util.List;

import com.org.entities.Client;
import com.org.entities.ClientPage;
import com.org.entities.ClientService;
import com.org.entities.ImageHero;

public interface IDaoClientPage {
    
	//we create the page first when the client registry
	public ClientPage createClientPage(Client client);
	public ClientPage updateAboutClientPage(String about, Client client);
	public ClientPage updateImageHeroClientPage(List<ImageHero> imageHero, Client client);
	
	//the client has one page, we don t need to pass the clientpage as parametre
	//we return from the client object
	public ClientService addClientService(ClientService clientService, Client client);
	public ClientService updateClientService(ClientService clientService, Client client);
	public boolean deleteClientService(Long idClientService, Client client);
	public ClientService getClientService(Long idClientService, Client client);
}
