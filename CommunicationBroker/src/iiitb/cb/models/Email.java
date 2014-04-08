package iiitb.cb.models;

public class Email extends Message{
	private String subject;
	private User cc;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public User getCc() {
		return cc;
	}
	public void setCc(User cc) {
		this.cc = cc;
	}
	
	public String toString(){
		return subject;
	}
	
}
