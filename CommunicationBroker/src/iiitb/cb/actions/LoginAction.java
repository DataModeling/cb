package iiitb.cb.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import iiitb.cb.models.User;
import iiitb.cb.models.impl.UserImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>,SessionAware{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	User user = new User();
	Map<String, Object> session;
	private List<String> countryList;

	public void validate(){
		UserImpl ui = new UserImpl();
		User temp = new User();
		temp.setEmail(user.getEmail());
		
		if(ui.isUsernameExists(temp)){
			try {
				makeCountryList();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addFieldError("email", "Email Already Exists");
		}
	}
	@SkipValidation
	public String isValidUser(){
		UserImpl uimpl = new UserImpl();
		if(uimpl.isValidUser(user)){
			session.put("email", user.getEmail());
			session.put("flag", 0);
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	@SkipValidation
	public String logout(){
		session.remove("email");
		session.remove("flag");
		return SUCCESS;
	}
	@SuppressWarnings("deprecation")
	public String registerUser(){
		
		UserImpl uimpl = new UserImpl();
		System.out.println(user.getDob());
		int age = new Date().getYear() - user.getDob().getYear();
		System.out.println(age);
		user.setAge(age);
		uimpl.registerUser(user);
		return SUCCESS;
	}
	
	public void makeCountryList() throws IOException {
		countryList = new ArrayList<String>();
		File f = new File("C:\\countries.txt");
		FileReader file = new FileReader(f);
		BufferedReader br = new BufferedReader(file);
		String temp = br.readLine();
		while (temp != null) {
			countryList.add(temp.toUpperCase());
			temp = br.readLine();
		}
		br.close();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public List<String> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
}
