package com.brainmentors.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class ShopAction implements Action,SessionAware {
	Map<String,Object> session;
	private String userid;
	private String msg;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public String execute(){
		if(session.get("uid")!=null){
			userid = (String)session.get("uid");
			this.msg = "U Login "+userid;
			return SUCCESS;
		}
		else{
			this.msg = "U R NOT LOGIN....";
			return ERROR;
		}
		
		
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		// TODO Auto-generated method stub
		
	}
}
