/**
 * 
 */
package com.onlinetutoring.service;

import java.util.List;

import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Student;

/**
 * @author Ssn
 *
 */
public interface IStudentService extends IBaseService<Student, Integer> {

	List<Course> getCourses(String email);

	List<Student> getApplication(int courseid);

	List<Course> getApplication(String email);

	void delApplication(int courseid);

	void delApplication(String email);

	void delStudentApplication(int courseid, int studentid);

	void delCourseApplication(int courseid, String email);

	void addApplication(String email, int courseid);

}
