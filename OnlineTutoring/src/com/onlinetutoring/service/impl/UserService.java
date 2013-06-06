/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.INotificationDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Answer;
import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Message;
import com.onlinetutoring.domain.Notification;
import com.onlinetutoring.domain.Question;
import com.onlinetutoring.domain.Student;
import com.onlinetutoring.domain.Subject;
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
	@Qualifier("notificationDao")
	private INotificationDao notificationDao;
	
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
			tutor.setCourses(new HashSet<Course>());
			tutor.setSubjects(new HashSet<Subject>());
			user.setTutor(tutor);
		} else if (type.equals("student")) {
			t = 's';
			student = new Student();
			student.setApplications(new HashSet<Course>());
			student.setCourses(new HashSet<Course>());
			user.setStudent(student);
		}
		user.setPassword(password);
		user.setEmail(email);
		user.setType(t);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		
		user.setAnswers(new HashSet<Answer>());
		user.setFriendsHaveMe(new HashSet<User>());
		user.setFriendsIHave(new HashSet<User>());
		user.setNotifications(new HashSet<Notification>());
		user.setQuestions(new HashSet<Question>());
		user.setReceives(new HashSet<Message>());
		user.setSends(new HashSet<Message>());

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
	@Override
	public void addFriend(String email, int userid){
		User queryUser = new User();
		queryUser.setEmail(email);
//		queryUser.setType((char) 0);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
		User friend = userDao.get(userid);
		
		System.out.println(user);
		System.out.println(friend);
		System.out.println(user.getFriendsHaveMe());
		System.out.println(user.getFriendsIHave());
		System.out.println(friend.getFriendsHaveMe());
		System.out.println(friend.getFriendsIHave());
		
		user.getFriendsHaveMe().add(friend);
		user.getFriendsIHave().add(friend);
		friend.getFriendsHaveMe().add(user);
		friend.getFriendsIHave().add(user);
		
//		userDao.update(user);
	}
	@Override
	public void delFriend(String email, int userid){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
		User friend = userDao.get(userid);
		
		user.getFriendsHaveMe().remove(friend);
		user.getFriendsIHave().remove(friend);
		friend.getFriendsHaveMe().remove(user);
		friend.getFriendsIHave().remove(user);
		
//		userDao.update(user);
	}
	@Override
	public List<User> getFriends(String email){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
		return new ArrayList<User>(user.getFriendsHaveMe());
	}
	@Override
	public void addFriendApplication(String email, int userid){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
		notificationDao.save(new Notification(userid, 'f', user));
	}

}
