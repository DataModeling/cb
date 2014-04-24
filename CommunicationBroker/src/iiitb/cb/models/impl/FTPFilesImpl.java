package iiitb.cb.models.impl;
import java.util.ArrayList;

import com.db4o.ObjectContainer;

import iiitb.cb.database.Db4oConnect;
import iiitb.cb.models.*;

public class FTPFilesImpl {

	Db4oConnect dbc = new Db4oConnect();

	public boolean addFile(String email ,FTP file){
		//ObjectContainer db  = dbc.createConnection();
		String filename =email+"#"+ file.getFileName();
		
		User u1 = new User();
		u1.setEmail(email);
		User u = dbc.getUserByEmail(u1);
		FTP proto = new FTP();
		proto.setFileName(filename);
		
		if(dbc.getFileByFilename(proto) == null)
		{
			Folder proto_folder_files = new Folder("Files", u);
			Folder files = dbc.getFolderByName(proto_folder_files);
			
			//ArrayList<FTP> filelist = new ArrayList<FTP>();
			files.getMessagesList().add(file);
			dbc.updateFolder(files);
		}
		else
		{
			dbc.closeConnection();
			return false;
		}
		
		dbc.closeConnection();
		return true;
	}

	public ArrayList<FTP> getAllFiles(String email) {
		// TODO Auto-generated method stub
		
		ArrayList<FTP> fileList  = new ArrayList<FTP>();
		
		User u1 = new User();
		u1.setEmail(email);
		User u = dbc.getUserByEmail(u1);
		
		Folder proto_folder_files = new Folder("Files", u);
		Folder files = dbc.getFolderByName(proto_folder_files);
		
		int listSize = files.getMessagesList().size();
		int i=0;
		
		while(i<listSize)
		{
			FTP f = new FTP();
			f = (FTP) files.getMessagesList().get(i);
			fileList.add(f);
			i++;
		}
		dbc.closeConnection();
		return fileList;
	}
}
