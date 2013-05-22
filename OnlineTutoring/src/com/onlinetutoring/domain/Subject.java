/**
 * 
 */
package com.onlinetutoring.domain;

import java.util.Set;

import javax.persistence.Id;

/**
 * @author Ssn
 *
 */
public class Subject  extends AbstractModel {

	@Id
	private int id;
	
	private String name;
	
	private Set<Tutor> tutors;
	
	private Set<Course> courses;
	
	private Set<Question> questions;

	/**
	 * 
	 */
	public Subject() {
	}

	/**
	 * @param name
	 */
	public Subject(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tutors
	 */
	public Set<Tutor> getTutors() {
		return tutors;
	}

	/**
	 * @param tutors the tutors to set
	 */
	public void setTutors(Set<Tutor> tutors) {
		this.tutors = tutors;
	}

	/**
	 * @return the courses
	 */
	public Set<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	/**
	 * @return the questions
	 */
	public Set<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	
	
}
