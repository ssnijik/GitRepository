/**
 * 
 */
package com.tutoring.entity;

import java.util.Set;

import javax.persistence.Id;

/**
 * @author Ssn
 *
 */
public class Student  extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	private User user;
	
	private int grade;

	private Set<Course> courses;
	
	private Set<Course> applications;

	/**
	 * 
	 */
	public Student() {
	}

	/**
	 * @param user
	 */
	public Student(User user) {
		this.user = user;
	}

	/**
	 * @param user
	 * @param grade
	 */
	public Student(User user, int grade) {
		this.user = user;
		this.grade = grade;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
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
	 * @return the applications
	 */
	public Set<Course> getApplications() {
		return applications;
	}

	/**
	 * @param applications the applications to set
	 */
	public void setApplications(Set<Course> applications) {
		this.applications = applications;
	}

	
}
