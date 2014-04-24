package iiitb.cb.models;

import java.util.ArrayList;
import java.util.List;



public class Server {
	private String serverName;
	private String suffix;
	private List<Folder> folderList;
	private List<User> usersList;
	private List<Group> groupsList;

	public Server(){
		
	}
	public Server(String suffix) {
		// TODO Auto-generated constructor stub
		this.suffix = suffix;
	}
	public Server(String serverName,String suffix, boolean isNewServer){
		this.serverName = serverName;
		this.suffix = suffix;
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
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
}
