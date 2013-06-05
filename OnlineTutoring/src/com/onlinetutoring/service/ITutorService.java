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

	List<Tutor> getTutors(String subjectName);

	void addSpecialty(String email, String subjectName);

	void addSpecialties(String email, List<Integer> subjectids);

	void delSpecialty(String email, String subjectName);

	List<Course> getCourses(String email);

}
