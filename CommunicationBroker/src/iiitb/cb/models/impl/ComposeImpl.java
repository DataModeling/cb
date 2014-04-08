package iiitb.cb.models.impl;


import iiitb.cb.database.Db4oConnect;
import iiitb.cb.models.Email;
import iiitb.cb.models.Folder;
import iiitb.cb.models.User;








import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class ComposeImpl {
	Db4oConnect dbc = new Db4oConnect();
	ObjectContainer database = dbc.createConnection();
	
	public void sendMail(Email e,User sender, User receiver,User cc,int is_cc)
	{
		
		Folder f1 = new Folder("inbox", receiver);
		Folder f2 = new Folder("outbox", sender);
		Folder f3 =  new Folder("inbox", cc);

		
		ObjectSet<Folder> serverInboxFind = database.queryByExample(f1);
		if(serverInboxFind.size()==0)
		{
			System.out.println("can't find receiver's inbox ");
		}
		Folder serverInbox = serverInboxFind.get(0);
		serverInbox.getEmailList().add(e);
		database.store(serverInbox);
		
		ObjectSet<Folder> serverOutboxFind = database.queryByExample(f2);
		if(serverOutboxFind.size()==0)
		{
			System.out.println("can't find sender's outbox ");
		}
		Folder serverOutbox = serverOutboxFind.get(0);
		serverOutbox.getEmailList().add(e);
		database.store(serverOutbox);
		
		if(is_cc==1)
		{
			ObjectSet<Folder> ccInboxFind = database.queryByExample(f3);
			if(ccInboxFind.size()==0)
			{
				System.out.println("can't find cc's inbox ");
			}
			Folder ccInbox = ccInboxFind.get(0);
			ccInbox.getEmailList().add(e);
			database.store(ccInbox);
		}
		
		
		dbc.closeConnection(database);
		
	}
	
	public User getUser(String email)
	{
		User u = new User();
		u.setEmail(email);
		User result = dbc.checkValidLogin(u,database);
		
		
		if(result!=null)
		{
			return result;
		}
		else 
		{
			dbc.closeConnection(database);
			return null ;
		}
	
	}

}
