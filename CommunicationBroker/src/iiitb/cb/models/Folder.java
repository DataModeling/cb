package iiitb.cb.models;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Prakash
 *
 */
public class Folder {
	private String folderName;
	private User user;
	private List<? super Message> emailList;

	
	public Folder(String string, User user2) {
		// TODO Auto-generated constructor stub
		this.folderName = string;
		this.user = user2;
		emailList = new ArrayList<>();
	}

	public List<? super Message> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<? super Message> emailList) {
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
