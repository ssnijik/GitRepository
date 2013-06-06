/**
 * 
 */
package com.onlinetutoring.service;

import java.util.List;

import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Tutor;

/**
 * @author Ssn
 * 
 */
public interface ITutorService extends IBaseService<Tutor, Integer> {

	/**
	 * 返回所有老师
	 * @return
	 */
	List<Tutor> getTutors();

	/**
	 * 根据老师（本人）的email和科目name添加一个专长
	 * @param email
	 * @param subjectName
	 */
	void addSpecialty(String email, String subjectName);

	/**
	 * 根据老师（本人）的email和科目name的List添加多个专长
	 * @param email
	 * @param subjectids
	 */
	void addSpecialties(String email, List<Integer> subjectids);

	/**
	 * 根据老师（本人）的email和科目name删除一个专长
	 * @param email
	 * @param subjectName
	 */
	void delSpecialty(String email, String subjectName);

	/**
	 * 根据老师（本人）的email获取该老师的所有课程
	 * @param email
	 * @return
	 */
	List<Course> getCourses(String email);

	/**
	 * 根据科目name获取科目下所有老师
	 * @param subjectName
	 * @return
	 */
	List<Tutor> getTutorsBySubject(String subjectName);

	/**
	 * 返回老师分页页数
	 * @param pageSize
	 * @return
	 */
	int getTutorPageCount(int pageSize);

	/**
	 * 返回分页老师
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<Tutor> getTutors(int pageNumber, int pageSize);

	/**
	 * 根据科目name返回老师分页页数
	 * @param subjectName
	 * @param pageSize
	 * @return
	 */
	int getTutorPageCountBySubjectPageCount(String subjectName, int pageSize);

	/**
	 * 根据科目name返回分页老师
	 * @param subjectName
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<Tutor> getTutorsBySubject(String subjectName, int pageNumber,
			int pageSize);

}
