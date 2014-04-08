package iiitb.cb.models.impl;


import iiitb.cb.database.Db4oConnect;
import iiitb.cb.models.Folder;
import iiitb.cb.models.Server;
import iiitb.cb.models.User;

public class FolderImpl {
	Folder f;
	public void createBasicFolders(User proto){
		Db4oConnect dbc = new Db4oConnect();
		User user = dbc.getUserByEmail(proto);
		Server server = dbc.getServerByName(new Server("EmailServer"));
		
		f = new Folder("Inbox",user);
		server.getFolderList().add(f);
		f = new Folder("Outbox",user);
		server.getFolderList().add(f);
		dbc.updateServer(server);
		dbc.closeConnection();
		
	}
}
