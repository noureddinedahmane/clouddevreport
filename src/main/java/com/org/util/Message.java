package com.org.util;

public class Message {

	
	private String message;
	private String messageType;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public Message(String message, String messageType) {
		super();
		this.message = message;
		this.messageType = messageType;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
