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
public class Tutor  extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private User user;	
	
	private int balance;
	
	private String description;
	
	private Set<Subject> subjects;
	
	private Set<Course> courses;

	/**
	 * 
	 */
	public Tutor() {
	}

	/**
	 * @param user
	 */
	public Tutor(User user) {
		this.user = user;
	}

	/**
	 * @param user
	 * @param balance
	 * @param description
	 */
	public Tutor(User user, int balance, String description) {
		this.user = user;
		this.balance = balance;
		this.description = description;
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
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the subjects
	 */
	public Set<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * @param subjects the subjects to set
	 */
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
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
