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

	List<Tutor> getTutors();

	void addSpecialty(String email, String subjectName);

	void addSpecialties(String email, List<Integer> subjectids);

	void delSpecialty(String email, String subjectName);

	List<Course> getCourses(String email);

	List<Tutor> getTutorsBySubject(String subjectName);

	int getTutorPageCount(int pageSize);

	List<Tutor> getTutors(int pageNumber, int pageSize);

	int getTutorPageCountBySubjectPageCount(String subjectName, int pageSize);

	List<Tutor> getTutorsBySubject(String subjectName, int pageNumber,
			int pageSize);

}
