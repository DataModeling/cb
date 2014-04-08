package iiitb.cb.models;

import java.util.Set;

public class Group {
	private String groupName;
	private Set<User> userGroup;
	 
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Set<User> getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(Set<User> userGroup) {
		this.userGroup = userGroup;
	}
}
