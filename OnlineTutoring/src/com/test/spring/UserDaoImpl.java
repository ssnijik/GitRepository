package com.test.spring;

import com.test.spring.UserDao;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if(username.equals("admin")&&password.equals("1234"))
			return true;
		return false;
	}
	
}
