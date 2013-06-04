/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.ICourseDao;
import com.onlinetutoring.dao.IStudentDao;
import com.onlinetutoring.dao.ISubjectDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Student;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.ICourseService;

/**
 * @author Ssn
 * 
 */
@Service("courseService")
public class CourseService extends BaseService<Course, Integer> implements
		ICourseService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CourseService.class);
	private ICourseDao courseDao;

	@Autowired
	@Qualifier("subjectDao")
	private ISubjectDao subjectDao;
	
	@Autowired
	@Qualifier("studentDao")
	private IStudentDao studentDao;

	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	@Autowired
	@Qualifier("courseDao")
	@Override
	public void setBaseDao(IBaseDao<Course, Integer> courseDao) {
		this.baseDao = courseDao;
		this.courseDao = (ICourseDao) courseDao;
	}

	public boolean addCourse(Date startTime, Date endTime, int duration,
			String email, int price, String name, String description,
			String subjectName) {

		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		return courseDao.save(new Course(startTime, endTime, duration, user
				.getTutor(), price, name, description, subject)) != null;

	}

	public void deleteCourse(int courseid) {
		courseDao.delete(courseid);
	}


	public void updateCourse(int courseid, Date startTime, Date endTime,
			int duration, int price, String name, String description,
			String subjectName) {

		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);

		Course course = courseDao.get(courseid);
		course.setStartTime(startTime);
		course.setEndTime(endTime);
		course.setDuration(duration);
		course.setPrice(price);
		course.setName(name);
		course.setDescription(description);
		course.setSubject(subject);

		courseDao.update(course);
	}

	public void updateRemark(int courseid, int ebta, int ebtb, int ebtc, int ebsa,
			int ebsb, int ebsc, String evaluation) {

		Course course = courseDao.get(courseid);
		course.setEbta(ebta);
		course.setEbtb(ebtb);
		course.setEbtc(ebtc);
		course.setEbsa(ebsa);
		course.setEbsb(ebsb);
		course.setEbsc(ebsc);
		course.setEvaluation(evaluation);
		
		courseDao.update(course);
	}

	public Course getCourse(int courseid) {

		return courseDao.get(courseid);
	}
	
	public List<Course> getCourses(){
		
		return new ArrayList<Course>(courseDao.listAll());
	}
	
	public int getCoursePageCount(int pageSize){
		int countAll = courseDao.countAll();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}
	
	public List<Course> getCourse(int pageNumber, int pageSize){
		return courseDao.listAll(pageNumber, pageSize);
	}
	
	
	
	public List<Course> getCoursesByTutor(String email){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();
		
		return new ArrayList<Course>(tutor.getCourses());
	}
	
	public int getCoursesByTutorPageCount(String email, int pageSize){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();
		
		int countAll = tutor.getCourses().size();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}
	
	public List<Course> getCoursesByTutor(String email, int pageNumber, int pageSize){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();
		
		List<Course> courseList = courseDao.listAll(pageNumber, pageSize, "model.tutor.id=" + tutor.getId());
		
		return courseList;
	}
	
	public List<Course> getCoursesBySubject(String subjectName){
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);
		
		return new ArrayList<Course>(subject.getCourses());
	}
	
	public int getCoursesBySubjectPageCount(String subjectName, int pageSize){
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);
		
		int countAll = subject.getCourses().size();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}
	
	public List<Course> getCoursesBySubject(String subjectName, int pageNumber, int pageSize){
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);
		
		List<Course> courseList = courseDao.listAll(pageNumber, pageSize, "model.subject.id=" + subject.getId());
		
		return courseList;
	}

	public void addApplication(String email, int courseid) {
		Course course = courseDao.get(courseid);

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();

		course.getApplications().add(student);
		student.getApplications().add(course);
		courseDao.update(course);

	}
	public List<Student> getApplication(int courseid) {

		Course course = courseDao.get(courseid);
//		Hibernate.initialize(course.getApplications());
		return new ArrayList<Student>(course.getApplications());
	}
	
	public List<Course> getApplication(String email) {

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();
		
//		Hibernate.initialize(student.getApplications());
		return new ArrayList<Course>(student.getApplications());
	}
	
	public void setApplication(int studentid, int courseid){
		Student student = studentDao.get(studentid);
		Course course = courseDao.get(courseid);
		
		course.setStudent(student);
		course.getApplications().clear();
		courseDao.update(course);
	}
	
	public void delApplication(int courseid){
		Course course = courseDao.get(courseid);
		course.getApplications().clear();
		courseDao.update(course);
	}
	
	public void delApplication(String email){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();
		
		student.getApplications().clear();
		studentDao.update(student);
	}
	
	public void delStudentApplication(int courseid, int studentid){
		Course course = courseDao.get(courseid);
		Student student = studentDao.get(studentid);
		course.getApplications().remove(student);
		courseDao.update(course);
	}
	
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
