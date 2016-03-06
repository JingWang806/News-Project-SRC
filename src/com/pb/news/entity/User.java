package com.pb.news.entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
	
	private String userName;
	private String password;

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		Constants.ONLINE_NUMBER++;

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		Constants.ONLINE_NUMBER--;

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
