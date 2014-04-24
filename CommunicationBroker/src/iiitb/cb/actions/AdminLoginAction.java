package iiitb.cb.actions;

import iiitb.cb.models.Server;
import iiitb.cb.models.impl.ServerImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminLoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6734189735992925753L;
	private String userName;
	private String password;
	
	public String execute(){
		if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	
	
}
