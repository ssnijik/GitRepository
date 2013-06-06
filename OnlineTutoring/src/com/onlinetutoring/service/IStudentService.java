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
	
	/**
	 * 根据根据本人email返回我的课程
	 * @param email
	 * @return
	 */
	List<Course> getCourses(String email);

	/**
	 * 根据课程id返回该课程的所有申请人（学生）
	 * 
	 * @param courseid
	 * @return
	 */
	List<Student> getApplication(int courseid);

	/**
	 * 根据学生email返回该学生的所有课程申请
	 * 
	 * @param email
	 * @return
	 */
	List<Course> getApplication(String email);

	/**
	 * 根据课程id删除该课程的所有申请人（学生）
	 * 
	 * @param courseid
	 */
	void delApplication(int courseid);

	/**
	 * 根据学生email删除该学生的所有课程申请
	 * 
	 * @param email
	 */
	void delApplication(String email);

	/**
	 * 根据学生id和课程id删除课程申请
	 * 
	 * @param courseid
	 * @param studentid
	 */
	void delCourseApplication(int courseid, int studentid);

	/**
	 * 根据学生email和课程id删除该学生的课程申请
	 * 
	 * @param courseid
	 * @param email
	 */
	void delCourseApplication(int courseid, String email);

	/**
	 * 根据本人的email和课程id添加课程申请
	 * 
	 * @param email
	 * @param courseid
	 */
	void addApplication(String email, int courseid);

}
