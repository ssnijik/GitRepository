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

	boolean addSubject(String subjectName);

	void updateSubject(String subjectName);

	void delSubject(String subjectName);

	List<Subject> getSubjects();

}
