package com.org.daoInter;

import java.util.List;

import com.org.entities.Client;
import com.org.entities.Message;

public interface IDaoMessage {
	
	public Message addMessage(Message message, Client client);
	public Message getMessage(Long idMessage, Client client);
	public Message updateMessage(Message message, Client client);
	public boolean deleteMessage(Long idMessage, Client client);
	public List<Message> listMessages(int min, int max, Client client);
	public List<Message> searchMessages(int min, int max, String subject, String email, String name, Client client);

}
