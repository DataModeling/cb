package iiitb.cb.models;

import java.util.ArrayList;
import java.util.List;



public class Server {
	private String serverName;
	private List<Folder> folderList;
	private List<User> usersList;
	private List<Group> groupsList;

	public Server(String string) {
		// TODO Auto-generated constructor stub
		this.serverName = string;
	}
	public Server(String string, boolean isNewServer){
		this.serverName = string;
		folderList = new ArrayList<Folder>();
		usersList = new ArrayList<User>();
		groupsList = new ArrayList<Group>();
	}
	public List<Group> getGroupsList() {
		return groupsList;
	}
	public void setGroupsList(List<Group> groupsList) {
		this.groupsList = groupsList;
	}
	public List<User> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public List<Folder> getFolderList() {
		return folderList;
	}
	public void setFolderList(List<Folder> folderList) {
		this.folderList = folderList;
	}
}
