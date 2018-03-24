package com.brainmentors.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.brainmentors.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport implements SessionAware{
	private String message;
	private String userid;
	private String password;
	
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
		return "success";
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
