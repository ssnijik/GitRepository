package com.test.spring;

import com.test.spring.UserBiz;

public class UserBizImpl implements UserBiz{

	UserDao userDAO;
	
	public void setUserDAO(UserDao userDAO){
		this.userDAO = userDAO;
	}
	
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return this.userDAO.login(username, password);
	}
	
}
