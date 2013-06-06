/**
 * 
 */
package com.onlinetutoring.service;

import java.util.List;

import com.onlinetutoring.domain.Subject;

/**
 * @author Ssn
 * 
 */
public interface ISubjectService extends IBaseService<Subject, Integer> {

	/**
	 * 添加一个科目
	 * @param subjectName
	 * @return
	 */
	boolean addSubject(String subjectName);

	/**
	 * 更新一个科目
	 * @param subjectName
	 */
	void updateSubject(String subjectName);

	/**
	 * 删除一个科目
	 * @param subjectName
	 */
	void delSubject(String subjectName);

	/**
	 * 返回所有科目
	 * @return
	 */
	List<Subject> getSubjects();

}
