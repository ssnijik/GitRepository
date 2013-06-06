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
	/**
	 * 添加一门课程
	 * @param startTime
	 * @param endTime
	 * @param duration
	 * @param email
	 * @param price
	 * @param name
	 * @param description
	 * @param subjectName
	 * @return
	 */
	public boolean addCourse(Date startTime, Date endTime, int duration, String email,
			int price, String name, String description, String subjectName);

	/**
	 * 根据课程id删除一门课程
	 * @param courseid
	 */
	public void deleteCourse(int courseid);

	/**
	 * 根据课程id更新一门课程
	 * @param courseid
	 * @param startTime
	 * @param endTime
	 * @param duration
	 * @param price
	 * @param name
	 * @param description
	 * @param subjectName
	 */
	public void updateCourse(int courseid, Date startTime, Date endTime, int duration,
			int price, String name, String description, String subjectName);

	/**
	 * 根据课程id更新评价
	 * @param courseid
	 * @param ebta
	 * @param ebtb
	 * @param ebtc
	 * @param ebsa
	 * @param ebsb
	 * @param ebsc
	 * @param evaluation
	 */
	public void updateRemark(int courseid, int ebta, int ebtb, int ebtc, int ebsa,
			int ebsb, int ebsc, String evaluation);

	/**
	 * 根据课程id返回课程
	 * @param courseid
	 * @return
	 */
	public Course getCourse(int courseid);

	/**
	 * 返回所有课程
	 * @return
	 */
	public List<Course> getCourses();

	/**
	 * 返回课程分页页数
	 * @param pageSize
	 * @return
	 */
	public int getCoursePageCount(int pageSize);

	/**
	 * 根据老师的email返回该老师的所有课程
	 * @param email
	 * @return
	 */
	public List<Course> getCoursesByTutor(String email);

	/**
	 * 根据老师的email返回该老师的课程分页页数
	 * @param email
	 * @param pageSize
	 * @return
	 */
	public int getCoursesByTutorPageCount(String email, int pageSize);

	/**
	 * 根据老师的email返回该老师的分页课程
	 * @param email
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Course> getCoursesByTutor(String email, int pageNumber, int pageSize);

	/**
	 * 根据科目名返回该科目下所有课程
	 * @param subjectName
	 * @return
	 */
	public List<Course> getCoursesBySubject(String subjectName);

	/**
	 * 根据科目名返回该科目下所有课程分页页数
	 * @param subjectName
	 * @param pageSize
	 * @return
	 */
	public int getCoursesBySubjectPageCount(String subjectName, int pageSize);

	/**
	 * 根据科目名返回该科目下分页课程
	 * @param subjectName
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Course> getCoursesBySubject(String subjectName, int pageNumber,
			int pageSize);

	/**
	 * 根据本人的email和课程id添加课程申请
	 * @param email
	 * @param courseid
	 */
	public void addApplication(String email, int courseid);

	/**
	 * 根据课程id返回该课程的所有申请人（学生）
	 * @param courseid
	 * @return
	 */
	public List<Student> getApplication(int courseid);

	/**
	 * 根据学生email返回该学生的所有课程申请
	 * @param email
	 * @return
	 */
	public List<Course> getApplication(String email);

	/**
	 * 根据课程id删除该课程的所有申请人（学生）
	 * @param courseid
	 */
	public void delApplication(int courseid);

	/**
	 * 根据学生email删除该学生的所有课程申请
	 * @param email
	 */
	public void delApplication(String email);

	/**
	 * 根据学生id和课程id删除课程申请
	 * @param courseid
	 * @param studentid
	 */
	public void delCourseApplication(int courseid, int studentid);

	/**
	 * 根据学生id和课程id添加学生确认课程申请
	 * @param courseid
	 * @param studentid
	 */
	public void addStudent(int courseid, int studentid);

	/**
	 * 根据学生email和课程id删除该学生的课程申请
	 * @param courseid
	 * @param email
	 */
	public void delCourseApplication(int courseid, String email);

	/**
	 * 返回分页课程
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Course> getCourses(int pageNumber, int pageSize);

}
