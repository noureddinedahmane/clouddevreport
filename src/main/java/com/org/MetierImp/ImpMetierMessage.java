package com.org.MetierImp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.org.daoInter.IDaoMessage;
import com.org.entities.Client;
import com.org.entities.Message;
import com.org.metierInter.IMetierMessage;

@Transactional
public class ImpMetierMessage implements IMetierMessage{

	private IDaoMessage daoMessage;
	
	
	public IDaoMessage getDaoMessage() {
		return daoMessage;
	}

	public void setDaoMessage(IDaoMessage daoMessage) {
		this.daoMessage = daoMessage;
	}
	

	@Override
	public Message addMessage(Message message, Client client) {
		return daoMessage.addMessage(message, client);
	}

	@Override
	public Message getMessage(Long idMessage, Client client) {
		return daoMessage.getMessage(idMessage, client);
	}

	@Override
	public Message updateMessage(Message message, Client client) {
		return daoMessage.updateMessage(message, client);
	}

	@Override
	public boolean deleteMessage(Long idMessage, Client client) {
		return daoMessage.deleteMessage(idMessage, client);
	}

	@Override
	public List<Message> listMessages(int min, int max, Client client) {
		return daoMessage.listMessages(min, max, client);
	}

	@Override
	public List<Message> searchMessages(int min, int max, String subject,
			String email, String name, Client client) {
		return daoMessage.searchMessages(min, max, subject, email, name, client);
	}

}
