/**
 * 
 */
package com.onlinetutoring.pojo;

import java.util.Set;

/**
 * @author Ssn
 *
 */
public class Course {

	private long id;
	
	private Subject subject;
	
	private String name;
	
	private int price;

	private Set<Arrangement> arrangements;
	
	/**
	 * 
	 */
	public Course() {
	}

	/**
	 * @param subject
	 * @param name
	 * @param price
	 */
	public Course(Subject subject, String name, int price) {
		this.subject = subject;
		this.name = name;
		this.price = price;
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
	 * @return the subject
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
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
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
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
