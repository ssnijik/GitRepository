/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
import com.onlinetutoring.dao.ISubjectDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Notification;
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
	@Qualifier("notificationDao")
	private INotificationDao notificationDao;

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
	@Override
	public boolean addCourse(Date startTime, Date endTime, int duration,
			String email, int price, String name, String description,
			String subjectName) {

		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
		Course course = new Course(startTime, endTime, duration, user
				.getTutor(), price, name, description, subject);
		
		course.setApplications(new HashSet<Student>());

		return courseDao.save(course) != null;

	}
	@Override
	public void deleteCourse(int courseid) {
		courseDao.delete(courseid);
	}

	@Override
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
	@Override
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
	@Override
	public Course getCourse(int courseid) {

		return courseDao.get(courseid);
	}
	@Override
	public List<Course> getCourses(){
		
		return new ArrayList<Course>(courseDao.listAll());
	}
	@Override
	public int getCoursePageCount(int pageSize){
		int countAll = courseDao.countAll();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}
	@Override
	public List<Course> getCourses(int pageNumber, int pageSize){
		return courseDao.listAll(pageNumber, pageSize);
	}
	
	
	@Override
	public List<Course> getCoursesByTutor(String email){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();
		
		return new ArrayList<Course>(tutor.getCourses());
	}
	@Override
	public int getCoursesByTutorPageCount(String email, int pageSize){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();
		
		int countAll = tutor.getCourses().size();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}
	@Override
	public List<Course> getCoursesByTutor(String email, int pageNumber, int pageSize){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();
		
		List<Course> courseList = courseDao.listAll(pageNumber, pageSize, "model.tutor.id=" + tutor.getId());
		
		return courseList;
	}
	@Override
	public List<Course> getCoursesBySubject(String subjectName){
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);
		
		return new ArrayList<Course>(subject.getCourses());
	}
	@Override
	public int getCoursesBySubjectPageCount(String subjectName, int pageSize){
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);
		
		int countAll = subject.getCourses().size();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}
	
	@Override
	public List<Course> getCoursesBySubject(String subjectName, int pageNumber, int pageSize){
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);
		
		List<Course> courseList = courseDao.listAll(pageNumber, pageSize, "model.subject.id=" + subject.getId());
		
		return courseList;
	}

	//TODO
//	public int getCoursesByStartTime(){
//		
//	}
	
	
	
	@Override
	public void addApplication(String email, int courseid) {
		Course course = courseDao.get(courseid);

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();

//		System.out.println("begin\n");
//		Hibernate.initialize(course.getApplications());
		course.getApplications().add(student);
//		System.out.println(course.getApplications().getClass().getSimpleName());
//		Hibernate.initialize(student.getApplications());
//		System.out.println(student.getApplications());
		student.getApplications().add(course);
//		studentDao.update(student);
//		courseDao.update(course);
		
//		System.out.println("end\n");
		notificationDao.save(new Notification(student.getId(), 's', course.getTutor().getUser()));
	}	
//	@Override
//	public void addApplication(int studentid, int courseid){
//		Student student = studentDao.get(studentid);
//		Course course = courseDao.get(courseid);
//		
//		course.setStudent(student);
//		course.getApplications().clear();
//		courseDao.update(course);
//		notificationDao.save(new Notification(studentid, 's', course.getTutor().getUser()));
//	}
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
	public void delApplication(int courseid){
		Course course = courseDao.get(courseid);
		for(Student s : course.getApplications()){
			s.getApplications().remove(course);
//			studentDao.update(s);
		}
		course.getApplications().clear();
//		courseDao.update(course);
	}
	@Override
	public void delApplication(String email){
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();
		
		for(Course c : student.getApplications()){
			c.getApplications().remove(student);
//			studentDao.update(s);
		}
		student.getApplications().clear();
//		studentDao.update(student);
	}
	@Override
	public void delStudentApplication(int courseid, int studentid){
		Course course = courseDao.get(courseid);
		Student student = studentDao.get(studentid);
		course.getApplications().remove(student);
		student.getApplications().remove(course);
//		courseDao.update(course);
	}
	@Override
	public void delCourseApplication(int courseid, String email){
		Course course = courseDao.get(courseid);
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Student student = user.getStudent();
		
		student.getApplications().remove(course);
		course.getApplications().remove(student);
//		studentDao.update(student);
	}
	@Override
	public void addStudent(int courseid, int studentid){
		Course course = courseDao.get(courseid);
		Student student = studentDao.get(studentid);
		course.setStudent(student);
		for(Student s : course.getApplications()){
			s.getApplications().remove(course);
			notificationDao.save(new Notification(courseid, 'a' + 'd', student.getUser()));
		}
		course.getApplications().clear();
//		courseDao.update(course);
		notificationDao.save(new Notification(courseid, 'a' + 'a', student.getUser()));
		notificationDao.save(new Notification(courseid, 'c', student.getUser()));
	}
	

}
