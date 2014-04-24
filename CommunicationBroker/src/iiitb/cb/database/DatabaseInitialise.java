/*package iiitb.cb.database;


import iiitb.cb.models.Server;

public class DatabaseInitialise {
	public static void main(String[] args){
		Db4oConnect dbc = new Db4oConnect();
		Server proto = new Server("EmailServer");
		Server s = dbc.getServerByName(proto);
		if(s == null){
			s = new Server("EmailServer", true);
			dbc.updateServer(s);
			dbc.closeConnection();
		}else{
			dbc.closeConnection();
			System.out.println("Server Exists");
		}
	}
}
*/