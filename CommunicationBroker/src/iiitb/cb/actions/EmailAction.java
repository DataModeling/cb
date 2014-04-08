package iiitb.cb.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iiitb.cb.models.Email;
import iiitb.cb.models.impl.EmailImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmailAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3427662530696442251L;
	Email email = new Email();
	private int flag;
	private String sender;
	private String subject;
	private String timestamp;
	private String reciever;

	private List<Email> emailsList;
	
	public String loadEmails(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		EmailImpl ei = new  EmailImpl();
		emailsList = new ArrayList<Email>();
		System.out.println((String)session.get("email"));
		System.out.println(flag);
		flag = (Integer)session.get("flag");
		flag=0;
		emailsList = ei.getEmails((String)session.get("email"), flag);
		session.put("flag", (flag));
		System.out.println("Prakash");
		return SUCCESS;
	}
	
	public String loadSelectedEmail(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		EmailImpl ei = new EmailImpl();
		String reciever = (String)session.get("email");
		email = ei.getEmail(sender, reciever, subject, timestamp);
		return SUCCESS;
	}
	
	public String loadOutboxEmails(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		EmailImpl ei = new  EmailImpl();
		emailsList = new ArrayList<Email>();
		System.out.println((String)session.get("email"));
		System.out.println(flag);
		flag = (Integer)session.get("flag");
		flag=0;
		emailsList = ei.getOutboxEmails((String)session.get("email"), flag);
		session.put("flag", (flag));
		System.out.println("Prakash");
		return SUCCESS;
	}
	
	public String loadSelectedOutboxEmail(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		EmailImpl ei = new EmailImpl();
		String sender = (String)session.get("email");
		email = ei.getOutboxEmail(reciever, sender, subject, timestamp);
		return SUCCESS;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public List<Email> getEmailsList() {
		return emailsList;
	}
	public void setEmailsList(List<Email> emailsList) {
		this.emailsList = emailsList;
	}
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

}
