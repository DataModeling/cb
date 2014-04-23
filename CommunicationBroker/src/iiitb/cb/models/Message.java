package iiitb.cb.models;

import java.util.Date;
import java.util.List;

public class Message {
	private User sender;
	private List<User> reciever;
	private String body;
	private Date timestamp;
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}

	public List<User> getReciever() {
		return reciever;
	}
	public void setReciever(List<User> reciever) {
		this.reciever = reciever;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
