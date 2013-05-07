/**
 * 
 */
package com.onlinetutoring.pojo;

import java.util.Set;


/**
 * @author Ssn
 *
 */
public class Tutor {

	private long id;

	private Person person;	
	
	private long salary;
	
	private String description;
	
	private Set<Subject> subjects;
	
	private Set<Arrangement> arrangements;

	
	/**
	 * 
	 */
	public Tutor() {
	}


	/**
	 * @param person
	 */
	public Tutor(Person person) {
		this.person = person;
	}


	/**
	 * @param person
	 * @param salary
	 * @param description
	 */
	public Tutor(Person person, long salary, String description) {
		this.person = person;
		this.salary = salary;
		this.description = description;
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
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}


	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	

	/**
	 * @return the salary
	 */
	public long getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(long salary) {
		this.salary = salary;
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
	 * @return the arrangements
	 */
	public Set<Arrangement> getArrangements() {
		return arrangements;
	}


	/**
	 * @param arrangements the arrangements to set
	 */
	public void setArrangements(Set<Arrangement> arrangements) {
		this.arrangements = arrangements;
	}
	
}
