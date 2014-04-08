package iiitb.cb.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import iiitb.cb.models.Email;
import iiitb.cb.models.impl.EmailImpl;

public class EmailInitialise {

	public static void main(String[] args){
		String sender = "pvk@mymail.com";

		String reciever = "dipesh@mymail.com";
		
		EmailImpl ei = new EmailImpl();
//Intialise some emails in Database	
		for(int i = 1; i<=20; i++){
			
			Email e = new Email();

			e.setSubject("Subject" + i);
			e.setBody("Hello Prakash Kharche,<br>Nice to see you on MyMail. This is a new mailing system we are trying using OODB"
					+ "and it feels that it is just awesome to use OODB as a database for website."
					+ "<br>Regards,<br>Administrator");
			try {
				Thread.sleep(1002);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			ei.addEmail(e, sender, reciever);
		}
//Retrieving 20 latest mails at a time		
		List<Email> emailsList = ei.getEmails(reciever, 0);
		System.out.println(emailsList);
		emailsList = ei.getEmails(reciever, 20);
		System.out.println(emailsList);
	}
}
