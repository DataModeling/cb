package iiitb.cb.models.impl;



import iiitb.cb.database.Db4oConnect;
import iiitb.cb.models.Server;
import iiitb.cb.models.User;

public class UserImpl {

	//user validation at time of login
	public boolean isValidUser(User user){
		Db4oConnect dbc = new Db4oConnect();
		System.out.println(user.getEmail());
		User u = dbc.getUserByEmail(user);

		if(u != null){
			dbc.closeConnection();
			return true;
		}else{
			dbc.closeConnection();
			return false;
		}
	}

	public void registerUser(User user, String serverSuffix){
		Db4oConnect dbc = new Db4oConnect();
		Server proto = new Server(serverSuffix);
		Server server = dbc.getServerByName(proto);
		server.getUsersList().add(user);
		dbc.updateServer(server);
		dbc.closeConnection();

		FolderImpl fi = new FolderImpl();		
		fi.createBasicFolders(user, serverSuffix);
	}

	public boolean isUsernameExists(User user) {
		// TODO Auto-generated method stub
		Db4oConnect dbc = new Db4oConnect();
		User u = dbc.getUserByEmail(user);

		if(u != null){
			dbc.closeConnection();
			return true;
		}else{
			dbc.closeConnection();
			return false;
		}
	}
}
