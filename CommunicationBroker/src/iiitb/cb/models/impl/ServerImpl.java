package iiitb.cb.models.impl;

import iiitb.cb.database.Db4oConnect;
import iiitb.cb.models.Server;


public class ServerImpl {

	public boolean addServer(Server s) {
		// TODO Auto-generated method stub
		Db4oConnect dbc = new Db4oConnect();
		
		Server proto = new Server(s.getSuffix(),null);
		Server server = dbc.getServerByName(proto);
		
		if(server == null){
			server = new Server(s.getServerName(),s.getSuffix(),"Email", true);
			dbc.updateServer(server);
			server = new Server(s.getServerName(),s.getSuffix(),"FTP", true);
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
		Server proto = new Server(suffix, null);
		Server server = dbc.getServerByName(proto);//change it to getServerBySuffix()
		if(server != null){
			dbc.closeConnection();
			return true;
		}else{
			dbc.closeConnection();
			return false;
		}
	}
	
	public boolean isSuffixAlreadyExists(String suffix){
		Db4oConnect dbc = new Db4oConnect();
		Server proto = new Server(suffix, null);
		Server server = dbc.getServerByName(proto);//change it to getServerBySuffix()
		if(server != null){
			dbc.closeConnection();
			return true;
		}else{
			dbc.closeConnection();
			return false;
		}
	}
	
}
