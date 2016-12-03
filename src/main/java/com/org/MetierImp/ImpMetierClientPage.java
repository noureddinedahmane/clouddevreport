package com.org.MetierImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoClientPage;
import com.org.entities.Client;
import com.org.entities.ClientPage;
import com.org.entities.ClientService;
import com.org.entities.ImageHero;
import com.org.metierInter.IMetierClientPage;

@Transactional
public class ImpMetierClientPage implements IMetierClientPage{
    
	private IDaoClientPage daoClientPage; 
	
	
	public IDaoClientPage getDaoClientPage() {
		return daoClientPage;
	}

	public void setDaoClientPage(IDaoClientPage daoClientPage) {
		this.daoClientPage = daoClientPage;
	}

	@Override
	public ClientPage createClientPage(Client client) {
		return daoClientPage.createClientPage(client);
	}

	@Override
	public ClientPage updateAboutClientPage(String about, Client client) {
		return daoClientPage.updateAboutClientPage(about, client);
	}

	@Override
	public ClientPage updateImageHeroClientPage(List<ImageHero> imageHero,
			Client client) {
		return daoClientPage.updateImageHeroClientPage(imageHero, client);
	}

	@Override
	public ClientService addClientService(ClientService clientService,
			Client client) {
		return daoClientPage.addClientService(clientService, client);
	}

	@Override
	public ClientService updateClientService(ClientService clientService,
			Client client) {
		return daoClientPage.updateClientService(clientService, client);
	}

	@Override
	public boolean deleteClientService(Long idClientService, Client client) {
		return daoClientPage.deleteClientService(idClientService, client);
	}

	@Override
	public ClientService getClientService(Long idClientService, Client client) {
		return daoClientPage.getClientService(idClientService, client);
	}

}
