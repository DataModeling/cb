package iiitb.cb.actions;


import iiitb.cb.models.Email;
import iiitb.cb.models.User;
import iiitb.cb.models.impl.ComposeImpl;





import iiitb.cb.models.impl.EmailImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class Compose  extends ActionSupport implements ModelDriven<Email>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Email e= new Email();
	String reciever_email;
	String cc_email;
	String sender_email;
	int is_cc=0;

	User sndr = new User();
	User rcvr = new User();
	User cc = new User();

	public String addEmail(){
		EmailImpl ei = new EmailImpl();
		Map<String, Object> session = ActionContext.getContext().getSession();
		String senderEmail = (String) session.get("email");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy(HH:mm:ss)");
		String temp = sdf.format(new Date());
		Date d = null;
		try {
			d = sdf.parse(temp);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.setTimestamp(d);
		ei.addEmail(e, senderEmail	,reciever_email);
		return SUCCESS;
	}
	public String execute()
	{
		ComposeImpl ci= new ComposeImpl();
		 Map<String, Object> session = ActionContext.getContext().getSession();
		sender_email = (String) session.get("email");
		User u1 =ci.getUser(sender_email);

		if(u1!=null)
		{
			System.out.println("sender name is : "+u1.getName());
			sndr = u1;
		}
		else
		{
			System.out.println(" sender does not exist");
			return ERROR;
		}

		User u2 = ci.getUser(reciever_email);
		if(u2 !=null)
		{
			System.out.println("receiver name is : "+u2.getName());
			rcvr = u2;
		}
		else
		{
			System.out.println(" receiver does not exist");
			return ERROR;
		}

		if(cc_email.equalsIgnoreCase(""))
		{
			System.out.println("cc is empty");
			cc = null;
			is_cc=0;
		}
		else
		{
			is_cc=1;
			User u3 = ci.getUser(cc_email);
			if(u3 !=null)
			{
				System.out.println("cc name is : "+u3.getName());
				cc = u3;
			}
			else
			{
				System.out.println(" receiver does not exist");
				return ERROR;
			}
		}

		Date date = new Date();
		System.out.println(date.toString());

		e.setTimestamp(date);
		e.setSender(sndr);
		e.setReciever(rcvr);
		e.setCc(cc);

		ci.sendMail(e,sndr,rcvr,cc,is_cc);

		return SUCCESS;
	}
	public String getCc_email() {
		return cc_email;
	}

	public void setCc_email(String cc_email) {
		this.cc_email = cc_email;
	}

	public User getCc() {
		return cc;
	}

	public void setCc(User cc) {
		this.cc = cc;
	}

	public User getRcvr() {
		return rcvr;
	}

	public void setRcvr(User rcvr) {
		this.rcvr = rcvr;
	}

	public Email getE() {
		return e;
	}

	public void setE(Email e) {
		this.e = e;
	}



	public String getReciever_email() {
		return reciever_email;
	}

	public void setReciever_email(String reciever_email) {
		this.reciever_email = reciever_email;
	}

	public String getSender_email() {
		return sender_email;
	}

	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}

	public User getSndr() {
		return sndr;
	}

	public void setSndr(User sndr) {
		this.sndr = sndr;
	}

	

	@Override
	public Email getModel() {
		// TODO Auto-generated method stub
		return e;
	}

}
