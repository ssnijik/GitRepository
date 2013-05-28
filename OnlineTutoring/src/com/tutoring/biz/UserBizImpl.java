package com.tutoring.biz;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tutoring.dao.UserDAO;


public class UserBizImpl implements UserBiz{

	UserDAO userDAO;

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		
		if(password.equals(userDAO.getPasswordByEmail(email))){
			return true;
		}
		return false;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	public boolean CanLoginBySession()
	{
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		
		if(session.get("email")!=null)
			return true;
		return false;
	}
	
	public boolean CanLoginByCookie()
	{
		return false;
	}
	
	public void register(String password,String email,String type,String firstname, String lastname)
	{
		char t;
		if(type.equals("student"))
		
			t='1';
			
		
		else
			t='2';
		userDAO.addUser(email, password,t,firstname,lastname);
		
	}

	@Override
	public boolean isUserExist(String email) {
		// TODO Auto-generated method stub
		if(userDAO.getUserByEmail(email)!=null)
			return true;
		else
			return false;
	}

	
	
	
	
}
