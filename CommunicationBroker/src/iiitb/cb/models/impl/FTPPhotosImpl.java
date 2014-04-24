package iiitb.cb.models.impl;

import iiitb.cb.database.Db4oConnect;
import iiitb.cb.models.FTP;
import iiitb.cb.models.User;

import com.db4o.ObjectContainer;

public class FTPPhotosImpl {
	Db4oConnect dbc = new Db4oConnect();

	public boolean addPhoto(String email ,FTP file){
		ObjectContainer db  = dbc.createConnection();
		String filename =email+"#"+ file.getFileName();
		
		User u1 = new User();
		u1.setEmail(email);
		User u = dbc.getUserByEmail(u1);
		FTP proto = new FTP();
		proto.setFileName(filename);
		
		if(dbc.getFileByFilename(proto) == null)
		{
			db.store(file);
		}
		
		
		return true;
	}
}