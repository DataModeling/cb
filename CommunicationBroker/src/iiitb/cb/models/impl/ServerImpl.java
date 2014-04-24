package iiitb.cb.models.impl;

import iiitb.cb.database.Db4oConnect;
import iiitb.cb.models.Server;


public class ServerImpl {

	public boolean addServer(Server s) {
		// TODO Auto-generated method stub
		Db4oConnect dbc = new Db4oConnect();
		
		Server proto = new Server(s.getSuffix());
		Server server = dbc.getServerByName(proto);
		
		if(server == null){
			server = new Server(s.getServerName(),s.getSuffix(), true);
			dbc.updateServer(server);
			dbc.closeConnection();
			return true;
		}else{
			dbc.closeConnection();
			System.out.println("Server Exists");
			return false;
		}
	}
//	public void addFolder(Folder f){
//		Db4oConnect dbc = new Db4oConnect();
//
//		Server proto = new Server("EmailServer");
//		Server server = dbc.getServerByName(proto);
//		server.getFolderList().add(f);
//		dbc.updateServer(server);
//		dbc.closeConnection();
//	}
//
//	public void addUser(User user) {
//		// TODO Auto-generated method stub
//		Db4oConnect dbc = new Db4oConnect();
//
//		Server proto = new Server("EmailServer");
//		Server server = dbc.getServerByName(proto);
//		server.getUsersList().add(user);
//		dbc.updateServer(server);
//		dbc.closeConnection();
//	}

	public boolean isValidSuffix(String suffix) {
		// TODO Auto-generated method stub
		Db4oConnect dbc = new Db4oConnect();
		Server proto = new Server(suffix);
		Server server = dbc.getServerByName(proto);//change it to getServerBySuffix()
		if(server != null){
			return true;
		}else{
			return false;
		}
	}
	
}
