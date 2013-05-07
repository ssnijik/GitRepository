/**
 * 
 */
package com.onlinetutoring.pojo;

import java.util.Set;

/**
 * @author Ssn
 *
 */
public class Subject {

	private long id;
	
	private Subject parentSubject;
	
	private Set<Subject> childSubjects;
	
	private Set<Tutor> tutors;
	
	private Set<Course> courses;

	/**
	 * 
	 */
	public Subject() {
	}

	/**
	 * @param parentSubject
	 */
	public Subject(Subject parentSubject) {
		this.parentSubject = parentSubject;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the parentSubject
	 */
	public Subject getParentSubject() {
		return parentSubject;
	}

	/**
	 * @param parentSubject the parentSubject to set
	 */
	public void setParentSubject(Subject parentSubject) {
		this.parentSubject = parentSubject;
	}

	/**
	 * @return the childSubjects
	 */
	public Set<Subject> getChildSubjects() {
		return childSubjects;
	}

	/**
	 * @param childSubjects the childSubjects to set
	 */
	public void setChildSubjects(Set<Subject> childSubjects) {
		this.childSubjects = childSubjects;
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
	
	
}
