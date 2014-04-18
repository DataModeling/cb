package iiitb.cb.models.impl;


import iiitb.cb.database.Db4oConnect;
import iiitb.cb.models.Email;
import iiitb.cb.models.Folder;
import iiitb.cb.models.User;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class ComposeImpl {
	
	public User getUser(String email)
	{
		Db4oConnect dbc = new Db4oConnect();
		User u = new User(email);
		
		User result = dbc.getUserByEmail(u);
		
		if(result!=null)
		{
			System.out.println("in composeImpl user exist : " +result);
			dbc.closeConnection();
			return result;
		}
		else 
		{
			dbc.closeConnection();
			return null ;
		}
	
	}
	
	public void sendEmail(Email e, User sender,User reciever,User cc,int is_cc) {
		// TODO Auto-generated method stub
		Db4oConnect dbc = new Db4oConnect();
			
		Folder proto_folder_recv = new Folder("Inbox", reciever);
		Folder inbox = dbc.getFolderByName(proto_folder_recv);
		
		Folder proto_folder_sender = new Folder("Outbox", sender);
		Folder outbox = dbc.getFolderByName(proto_folder_sender);
		
		inbox.getEmailList().add(e);
		outbox.getEmailList().add(e);
		
		dbc.updateFolder(inbox);
		dbc.updateFolder(outbox);
		
		if(is_cc==1)
		{
			Folder proto_folder_cc = new Folder("Inbox", cc);
			Folder inboxcc = dbc.getFolderByName(proto_folder_cc);
			inboxcc.getEmailList().add(e);
			dbc.updateFolder(inboxcc);

		}
		dbc.closeConnection();
		
	}

}
