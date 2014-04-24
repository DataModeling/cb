package iiitb.cb.models;

import java.util.ArrayList;
import java.util.List;



public class Server {
	private String serverName;
	private String suffix;
	private String serviceType;
	private List<Folder> folderList;
	private List<User> usersList;
	private List<Group> groupsList;

	public Server(){
		
	}
	public Server(String suffix, String serviceType) {
		// TODO Auto-generated constructor stub
		this.suffix = suffix;
		this.serviceType = serviceType;
	}
	public Server(String serverName,String suffix,String serviceType, boolean isNewServer){
		this.serverName = serverName;
		this.suffix = suffix;
		this.serviceType = serviceType;
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
}
