package com.test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tutoring.biz.UserBiz;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String username;
	public String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public String execute() throws Exception
	{
		//userBiz.deleteUser("e2@mail.com");
		return ERROR;
	}
	
}

