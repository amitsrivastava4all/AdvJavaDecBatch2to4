package com.brainmentors.actions;

public class WelcomeAction {
	private String message;
	
	public String sayWelcome(){
		message = "Welcome User";
		return "success";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
