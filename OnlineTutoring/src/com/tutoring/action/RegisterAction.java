package com.tutoring.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tutoring.biz.UserBiz;

public class RegisterAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private String type;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPassword() {
		return password;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public String execute() throws Exception{
		//System.out.println(type);
		userBiz.register(password, email, type,firstname,lastname);
		return SUCCESS;
	}
	
	
	public String checkEmail(String email)
	{
		//System.out.println(username);
		if(userBiz.isUserExist(email))
		{
			//System.out.println("exist");
			return "exist";
		}
		return "ok";
	}
	
	
}
