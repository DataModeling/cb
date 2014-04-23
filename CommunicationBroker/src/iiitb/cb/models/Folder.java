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
	private List<? super Message> messagesList;

	
	public Folder(String string, User user2) {
		// TODO Auto-generated constructor stub
		this.folderName = string;
		this.user = user2;
		messagesList = new ArrayList<>();
	}



	public List<? super Message> getMessagesList() {
		return messagesList;
	}



	public void setMessagesList(List<? super Message> messagesList) {
		this.messagesList = messagesList;
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
