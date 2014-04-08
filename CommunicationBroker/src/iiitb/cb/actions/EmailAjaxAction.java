package iiitb.cb.actions;

import iiitb.cb.models.Email;
import iiitb.cb.models.impl.EmailImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmailAjaxAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5480084391146507153L;
	Email email = new Email();
	private int flag;
	private int saturateNext;
	private int saturatePrevious;
	private List<Email> emailsList;


	public String loadNextEmailsAjax(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		EmailImpl ei = new  EmailImpl();
		emailsList = new ArrayList<Email>();
		System.out.println((String)session.get("email"));
		System.out.println(flag);
		flag = (Integer)session.get("flag")+20;

		emailsList = ei.getEmails((String)session.get("email"), flag);
		if(emailsList.size() < 20){
			saturateNext = 1;
		}
		session.put("flag", (flag));
		System.out.println("Kharche");
		
		return SUCCESS;
	}
	
	public String loadPreviousEmailAjax(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		EmailImpl ei = new  EmailImpl();
		emailsList = new ArrayList<Email>();
		System.out.println((String)session.get("email"));
		flag = (Integer)session.get("flag")-20;
		System.out.println(flag);

		emailsList = ei.getEmails((String)session.get("email"), flag);
		if(flag == 0){
			saturatePrevious = 1;
		}
		session.put("flag", (flag));
		System.out.println("Kharche");
		
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
	public int getSaturateNext() {
		return saturateNext;
	}

	public void setSaturateNext(int saturateNext) {
		this.saturateNext = saturateNext;
	}

	public int getSaturatePrevious() {
		return saturatePrevious;
	}

	public void setSaturatePrevious(int saturatePrevious) {
		this.saturatePrevious = saturatePrevious;
	}
}
