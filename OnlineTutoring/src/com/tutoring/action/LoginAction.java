package com.tutoring.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tutoring.biz.UserBiz;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
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
	
	public String execute() throws Exception{
		if(userBiz.login(username, password)){
			ActionContext ac = ActionContext.getContext();
			Map<String, Object> session = ac.getSession();
			session.put("email", username);
			//System.out.println(session.get("username"));
			return SUCCESS;
		}
		else
			return LOGIN;
	}
	public String CanLoginDirectly()
	{
		if(userBiz.CanLoginBySession())
			return "ok";
		return "no";
	}
	
	
}
