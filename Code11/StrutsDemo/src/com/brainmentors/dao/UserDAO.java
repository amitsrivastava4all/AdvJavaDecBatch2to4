package com.brainmentors.dao;

public class UserDAO {
	public boolean isLogin(String userid, String password){
		return userid.equals(password);
	}
}
