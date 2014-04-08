package iiitb.cb.models;

import java.util.ArrayList;
import java.util.List;


public class Folder {
	private String folderName;
	private User user;
	private List<Email> emailList;

	
	public Folder(String string, User user2) {
		// TODO Auto-generated constructor stub
		this.folderName = string;
		this.user = user2;
		emailList = new ArrayList<Email>();
	}
	public List<Email> getEmailList() {
		return emailList;
	}
	public void setEmailList(List<Email> emailList) {
		this.emailList = emailList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}


}
