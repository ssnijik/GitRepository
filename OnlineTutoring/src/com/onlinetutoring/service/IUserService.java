/**
 * 
 */
package com.onlinetutoring.service;

import java.util.Date;

import com.onlinetutoring.domain.User;

/**
 * @author Ssn
 * 
 */
public interface IUserService extends IBaseService<User, Integer> {

	public boolean login(String email, String password);

	public boolean canLoginBySession();

	public boolean canLoginByCookie();

	public boolean addUser(String password, String email, String type,
			String firstname, String lastname);

	public boolean isUserExist(String email);

	void updateUser(String password, String email, String firstname,
			String lastname, String phone, Date birthday, String cardNumber,
			String picture, String school);
}
