package iiitb.cb.database;


import iiitb.cb.models.Email;
import iiitb.cb.models.Folder;
import iiitb.cb.models.Server;
import iiitb.cb.models.User;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ta.TransparentActivationSupport;
import com.db4o.ta.TransparentPersistenceSupport;

public class Db4oConnect {

	EmbeddedConfiguration config;
	ObjectContainer database;
	String dbName = "E:\\IIITB\\cb_database.yap";
	public Db4oConnect() {
		// TODO Auto-generated constructor stub
		config = Db4oEmbedded.newConfiguration();
		config.common().add(new TransparentActivationSupport());
		config.common().add(new TransparentPersistenceSupport());
		config.common().objectClass(Server.class).cascadeOnUpdate(true);
		config.common().objectClass(Folder.class).cascadeOnUpdate(true);
		//config.common().objectClass(Server.class).cascadeOnDelete(true);
		database = Db4oEmbedded.openFile(config,dbName);
	}
	public ObjectContainer createConnection()
	{
		//database = Db4o.openFile("commBroker.yap");
		
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().objectClass(Folder.class).cascadeOnUpdate(true);
		config.common().objectClass(Server.class).cascadeOnUpdate(true);
		
		database = Db4oEmbedded.openFile(config, "cb_database.yap");
		return database;
	}
	
	public void closeConnection(ObjectContainer database)
	{

		if(database.close())
		{
			System.out.println("database closed");
		}
		else
		{
			System.out.println("databse can't be closed");
		}
	}
	//To close the connection
	public void closeConnection(){
		if(database.close()){
			System.out.println("Connection Closed Successfully");
		}else{
			System.out.println("Connection Closing Failed");
		}
	}

	//User Related Methods
	public User getUserByEmail(User u){
	
		ObjectSet<User> result = database.queryByExample(u);

		if(result.hasNext())
		{
			System.out.println("valid user : " +result.get(0).getName());
			return result.next();
		}
		else
		{
			System.out.println("not a valid user");
			return null;
		}
	}

	public void addUser(User u){
		try{
			database.store(u);
		}catch(DatabaseClosedException dbe){
			dbe.printStackTrace();
		}
		System.out.println();
	}

	//Server Related Methods
	public Server getServerByName(Server s){

		ObjectSet<Server> serverSet = database.queryByExample(s);
		if(serverSet.hasNext())
			return serverSet.next();
		else
			return null;
	}

	public void updateServer(Server s) {
		// TODO Auto-generated method stub
		database.store(s);
	}
	public Folder getFolderByName(Folder folder) {
		// TODO Auto-generated method stub
		System.out.println("in getFolderByName "+ folder);
		ObjectSet<Folder> folderSet = database.queryByExample(folder);

		if(folderSet.hasNext()){
			System.out.println("folder present");
			return folderSet.next();
		}else{
			return null;
		}
	}
	
	public Email getEmail(Email e){
		ObjectSet<Email> result = database.queryByExample(e);
		
		if(result.hasNext()){
			return result.next();
		}else{
			return null;
		}
	}
	
	//Folder related queries
	public void updateFolder(Folder folder) {
		// TODO Auto-generated method stub
		try{
			database.store(folder);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Email related queries

	//abhishek methods

	public User checkValidLogin(User l , ObjectContainer database)
	{
		System.out.println(" test user email"+l.getEmail());
		ObjectSet<User> result = database.queryByExample(l);
		
		if(result.size()!=0)
		{
			System.out.println("in db4oConnect user found"+ result.get(0).getName());
			return result.get(0);
		}
		else 
		{
			System.out.println("in db4oConnect user not found");
			return null ;
		}
	}
	
	
	public ObjectSet<User> AllUsers()
	{
		int i=0;
		User tmp= new User();
		ObjectSet<User> u = database.queryByExample(tmp);
		i = u.size();
		System.out.println("in db object list size is : " + i);
		return u;																// it is returning user object set.
	}
}
