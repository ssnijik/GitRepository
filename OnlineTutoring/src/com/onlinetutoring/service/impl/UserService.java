/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Student;
import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IUserService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Ssn
 * 
 */
@Service("userService")
public class UserService extends BaseService<User, Integer> implements
		IUserService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserService.class);
	private IUserDao userDao;

	@Autowired
	@Qualifier("userDao")
	@Override
	public void setBaseDao(IBaseDao<User, Integer> userDao) {
		this.baseDao = userDao;
		this.userDao = (IUserDao) userDao;
	}

	@Override
	public boolean login(String email, String password) {
		User queryUser = new User();
		queryUser.setEmail(email);
		queryUser.setPassword(password);
		return userDao.queryByCriteriaUnique(queryUser) != null;
	}

	@Override
	public boolean canLoginBySession() {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();

		return session.get("email") != null;
	}

	@Override
	public boolean canLoginByCookie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(String password, String email, String type,
			String firstname, String lastname) {
		User user = new User();
		Tutor tutor;
		Student student;
		char t = 'a';
		if (type.equals("tutor")) {
			t = 't';
			tutor = new Tutor();
			user.setTutor(tutor);
		} else if (type.equals("student")) {
			t = 's';
			student = new Student();
			user.setStudent(student);
		}
		user.setPassword(password);
		user.setEmail(email);
		user.setType(t);
		user.setFirstName(firstname);
		user.setLastName(lastname);

		return userDao.save(user) != null;
	}

	@Override
	public boolean isUserExist(String email) {
		User user = new User();
		user.setEmail(email);
		return userDao.queryByCriteriaUnique(user) != null;
	}
	@Override
	public void updateUser(String password, String email, String firstname,
			String lastname, String phone, Date birthday, String cardNumber,
			String picture, String school) {
		User QueryUser = new User();
		QueryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(QueryUser);
		user.setPassword(password);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setPhone(phone);
		user.setBirthday(birthday);
		user.setCardNumber(cardNumber);
		user.setPicture(picture);
		user.setSchool(school);
		
		userDao.update(user);

	}

}
