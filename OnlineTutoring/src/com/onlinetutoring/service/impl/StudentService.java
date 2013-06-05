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
import com.onlinetutoring.dao.IStudentDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Student;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IStudentService;

/**
 * @author Ssn
 *
 */
@Service("studentService")
public class StudentService extends BaseService<Student, Integer> implements IStudentService{

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	private IStudentDao studentDao;
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;
	
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
    public List<Course> getCourses(String email){
    	User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();
		
		return new ArrayList<Course>(student.getCourses());
    }

    
    @Override
    public void addApplication(String email, int courseid) {
		Course course = courseDao.get(courseid);

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();

		course.getApplications().add(student);
		student.getApplications().add(course);
		studentDao.update(student);

	}
    @Override
	public List<Student> getApplication(int courseid) {

		Course course = courseDao.get(courseid);
//		Hibernate.initialize(course.getApplications());
		return new ArrayList<Student>(course.getApplications());
	}
    @Override
	public List<Course> getApplication(String email) {

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();
		
//		Hibernate.initialize(student.getApplications());
		return new ArrayList<Course>(student.getApplications());
	}
    @Override
	public void addApplication(int studentid, int courseid){
		Student student = studentDao.get(studentid);
		Course course = courseDao.get(courseid);
		
		course.setStudent(student);
		course.getApplications().clear();
		studentDao.update(student);
	}
    @Override
	public void delApplication(int courseid){
		Course course = courseDao.get(courseid);
		course.getApplications().clear();
		courseDao.update(course);
	}
    @Override
	public void delApplication(String email){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();
		
		student.getApplications().clear();
		studentDao.update(student);
	}
    @Override
	public void delStudentApplication(int courseid, int studentid){
		Course course = courseDao.get(courseid);
		Student student = studentDao.get(studentid);
		course.getApplications().remove(student);
		courseDao.update(course);
	}
    @Override
	public void delCourseApplication(String email, int courseid){
		Course course = courseDao.get(courseid);
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();
		
		student.getApplications().remove(course);
		studentDao.update(student);
	}
}
