package com.brainmentors.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.components.ActionError;
import org.apache.struts2.components.FieldError;
import org.apache.struts2.interceptor.SessionAware;

import com.brainmentors.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport implements SessionAware{
	private String message;
	private String userid;
	private String password;
	private List<String> country = new ArrayList<String>();
	private Map<Integer,String> qualification = new HashMap<Integer,String>();
	
	@Override
	public void validate(){
		if(userid.trim().length()==0){
			this.addFieldError("userid", this.getText("userid.error"));
		}
		if(password.trim().length()==0){
			this.addFieldError("password", this.getText("password.error"));
		}
		else
		if(password.length()<8)
		{
			this.addFieldError("password", this.getText("password.limit.error"));
		}
		
	}
	
	
	
	
	public Map<Integer, String> getQualification() {
		return qualification;
	}



	public void setQualification(Map<Integer, String> qualification) {
		this.qualification = qualification;
	}



	public List<String> getCountry() {
		return country;
	}



	public void setCountry(List<String> country) {
		this.country = country;
	}



	public void fillCountry(){
		country.add("India");
		country.add("Srilanka");
		country.add("USA");
		
	}
	
	public void fillQua(){
		qualification.put(10, "BCA");
		qualification.put(11, "MCA");
		qualification.put(12, "BBA");
		qualification.put(13, "MBA");
		qualification.put(14, "BTECH");
	}
//	public String execute(){
//		return null;
//	}
	
	
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String sayWelcome(){
		message = "Welcome User";
		this.fillQua();
		this.fillCountry();
		return SUCCESS;
	}
	@Override
	public String execute(){
		UserDAO userDAO = new UserDAO();
		if(userDAO.isLogin(userid, password)){
			session.put("uid", userid);
			this.message = "Welcome "+userid;
			return SUCCESS;
		}
		else{
			this.message = "Invalid Userid or Password";
			return ERROR;
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	private Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
		
	}
	

}
