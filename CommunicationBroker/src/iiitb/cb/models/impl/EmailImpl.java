package iiitb.cb.models.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import iiitb.cb.database.Db4oConnect;
import iiitb.cb.models.Email;
import iiitb.cb.models.Folder;
import iiitb.cb.models.User;

public class EmailImpl {

	/*public void addEmail(Email e, String s, String r) {
		// TODO Auto-generated method stub
		Db4oConnect dbc = new Db4oConnect();
		
		User proto_sender = new User(s);
		User sender = dbc.getUserByEmail(proto_sender);
		e.setSender(sender);
		
		User proto_recv = new User(r);
		User reciever = dbc.getUserByEmail(proto_recv);
		e.setReciever(reciever);
		
		Folder proto_folder_recv = new Folder("Inbox", reciever);
		Folder inbox = dbc.getFolderByName(proto_folder_recv);
		
		Folder proto_folder_sender = new Folder("Outbox", sender);
		Folder outbox = dbc.getFolderByName(proto_folder_sender);
		
		inbox.getEmailList().add(e);
		outbox.getEmailList().add(e);
		
		dbc.updateFolder(inbox);
		dbc.updateFolder(outbox);
		dbc.closeConnection();
		
	}*/
	
	public List<Email> getEmails(String email, int flag){
		Db4oConnect dbc = new Db4oConnect();
		List<Email> emailsList = new ArrayList<Email>();
		User proto = new User(email);
		User user = dbc.getUserByEmail(proto);
		
		Folder proto_folder = new Folder("Inbox", user);
		Folder f = dbc.getFolderByName(proto_folder);
		
		int listSize = f.getEmailList().size(), i=0;
		//hardcoded to 20
		while(i < 20 && (flag+i) < listSize){
			Email e = (Email) f.getEmailList().get((listSize-1)-flag-i);
			emailsList.add(e);
			i++;
		}
		dbc.closeConnection();
		return emailsList;
		
	}

	public Email getEmail(String s, String r, String subject, String timestamp) {
		// TODO Auto-generated method stub
		String[] tokens = s.split(",");
		
		Db4oConnect dbc = new Db4oConnect();
		User proto_sender = new User(tokens[1]);
		User sender = dbc.getUserByEmail(proto_sender);
		
		User proto_recv = new User(r);
		User reciever = dbc.getUserByEmail(proto_recv);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy(HH:mm:ss)");
		Date d = null;
		try {
			d = formatter.parse(timestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Email email_proto = new Email();
		email_proto.setSender(sender);
		email_proto.setSubject(subject);
		email_proto.setTimestamp(d);
		
		Email email = dbc.getEmail(email_proto);
		dbc.closeConnection();
		
		return email;
	}

	public List<Email> getOutboxEmails(String email, int flag) {
		// TODO Auto-generated method stub
		Db4oConnect dbc = new Db4oConnect();
		List<Email> emailsList = new ArrayList<Email>();
		User proto = new User(email);
		User user = dbc.getUserByEmail(proto);
		
		Folder proto_folder = new Folder("Outbox", user);
		Folder f = dbc.getFolderByName(proto_folder);
		
		int listSize = f.getEmailList().size(), i=0;
		//hardcoded to 20
		while(i < 20 && (flag+i) < listSize){
			Email e = (Email) f.getEmailList().get((listSize-1)-flag-i);
			emailsList.add(e);
			i++;
		}
		dbc.closeConnection();
		return emailsList;
		
	}
	public Email getOutboxEmail(String r, String s, String subject, String timestamp) {
		// TODO Auto-generated method stub
		String[] tokens = r.split(",");
		
		Db4oConnect dbc = new Db4oConnect();
		User proto_recv = new User(tokens[1]);
		User reciever = dbc.getUserByEmail(proto_recv);
		
		User proto_sender = new User(r);
		User sender = dbc.getUserByEmail(proto_sender);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy(HH:mm:ss)");
		Date d = null;
		try {
			d = formatter.parse(timestamp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Email email_proto = new Email();
		email_proto.setSender(sender);
		email_proto.setSubject(subject);
		email_proto.setTimestamp(d);
		
		Email email = dbc.getEmail(email_proto);
		dbc.closeConnection();
		
		return email;
	}


}
