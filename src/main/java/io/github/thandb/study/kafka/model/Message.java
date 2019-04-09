package io.github.thandb.study.kafka.model;

import java.util.Date;

public class Message {
	private String sender;
	private String receiver;
	private String message;
	private Date createdTime;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return String.format("Message [sender=%s, receiver=%s, message=%s, createdTime=%s]", sender, receiver, message,
				createdTime);
	}
}
