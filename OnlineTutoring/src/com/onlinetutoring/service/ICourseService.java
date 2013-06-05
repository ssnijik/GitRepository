/**
 * 
 */
package com.onlinetutoring.service;

import java.util.Date;
import java.util.List;

import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Student;

/**
 * @author Ssn
 *
 */
public interface ICourseService extends IBaseService<Course, Integer> {

	boolean addCourse(Date startTime, Date endTime, int duration, String email,
			int price, String name, String description, String subjectName);

	void deleteCourse(int courseid);

	void updateCourse(int courseid, Date startTime, Date endTime, int duration,
			int price, String name, String description, String subjectName);

	void updateRemark(int courseid, int ebta, int ebtb, int ebtc, int ebsa,
			int ebsb, int ebsc, String evaluation);

	Course getCourse(int courseid);

	List<Course> getCourses();

	int getCoursePageCount(int pageSize);

	List<Course> getCourse(int pageNumber, int pageSize);

	List<Course> getCoursesByTutor(String email);

	int getCoursesByTutorPageCount(String email, int pageSize);

	List<Course> getCoursesByTutor(String email, int pageNumber, int pageSize);

	List<Course> getCoursesBySubject(String subjectName);

	int getCoursesBySubjectPageCount(String subjectName, int pageSize);

	List<Course> getCoursesBySubject(String subjectName, int pageNumber,
			int pageSize);

	void addApplication(String email, int courseid);

//	void addApplication(int studentid, int courseid);

	List<Student> getApplication(int courseid);

	List<Course> getApplication(String email);

	void delApplication(int courseid);

	void delApplication(String email);

	void delStudentApplication(int courseid, int studentid);

	void delCourseApplication(String email, int courseid);

	void addStudent(int courseid, int studentid);

}
