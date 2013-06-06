/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.ICourseDao;
import com.onlinetutoring.dao.INotificationDao;
import com.onlinetutoring.dao.IStudentDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Notification;
import com.onlinetutoring.domain.Student;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IStudentService;

/**
 * @author Ssn
 * 
 */
@Service("studentService")
public class StudentService extends BaseService<Student, Integer> implements
		IStudentService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(StudentService.class);
	private IStudentDao studentDao;

	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	@Autowired
	@Qualifier("notificationDao")
	private INotificationDao notificationDao;

	@Autowired
	@Qualifier("courseDao")
	private ICourseDao courseDao;

	@Autowired
	@Qualifier("studentDao")
	@Override
	public void setBaseDao(IBaseDao<Student, Integer> studentDao) {
		this.baseDao = studentDao;
		this.studentDao = (IStudentDao) studentDao;
	}

	@Override
	public void addApplication(String email, int courseid) {
		Course course = courseDao.get(courseid);

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();

		// System.out.println("begin\n");
		// Hibernate.initialize(course.getApplications());
		course.getApplications().add(student);
		// System.out.println(course.getApplications().getClass().getSimpleName());
		// Hibernate.initialize(student.getApplications());
		// System.out.println(student.getApplications());
		student.getApplications().add(course);
		// studentDao.update(student);
		// courseDao.update(course);

		// System.out.println("end\n");
		notificationDao.save(new Notification(student.getId(), 's', course
				.getTutor().getUser()));
	}

	// @Override
	// public void addApplication(int studentid, int courseid){
	// Student student = studentDao.get(studentid);
	// Course course = courseDao.get(courseid);
	//
	// course.setStudent(student);
	// course.getApplications().clear();
	// courseDao.update(course);
	// notificationDao.save(new Notification(studentid, 's',
	// course.getTutor().getUser()));
	// }
	@Override
	public List<Student> getApplication(int courseid) {

		Course course = courseDao.get(courseid);
		// Hibernate.initialize(course.getApplications());
		return new ArrayList<Student>(course.getApplications());
	}

	@Override
	public List<Course> getApplication(String email) {

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();

		// Hibernate.initialize(student.getApplications());
		return new ArrayList<Course>(student.getApplications());
	}

	@Override
	public void delApplication(int courseid) {
		Course course = courseDao.get(courseid);
		for (Student s : course.getApplications()) {
			s.getApplications().remove(course);
			// studentDao.update(s);
		}
		course.getApplications().clear();
		// courseDao.update(course);
	}

	@Override
	public void delApplication(String email) {
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();

		for (Course c : student.getApplications()) {
			c.getApplications().remove(student);
			// studentDao.update(s);
		}
		student.getApplications().clear();
		// studentDao.update(student);
	}

	@Override
	public void delCourseApplication(int courseid, int studentid) {
		Course course = courseDao.get(courseid);
		Student student = studentDao.get(studentid);
		course.getApplications().remove(student);
		student.getApplications().remove(course);
		// courseDao.update(course);
	}

	@Override
	public void delCourseApplication(int courseid, String email) {
		Course course = courseDao.get(courseid);
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();

		student.getApplications().remove(course);
		course.getApplications().remove(student);
		// studentDao.update(student);
	}

	@Override
	public List<Course> getCourses(String email) {
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();

		return new ArrayList<Course>(student.getCourses());
	}

}
