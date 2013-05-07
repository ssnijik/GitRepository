/**
 * 
 */
package com.onlinetutoring.pojo;

import java.util.Set;

/**
 * @author Ssn
 *
 */
public class Student {

	private long id;
	
	private Person person;
	
	private long balance;
	
	private int grade;

	private Set<StudentTimetable> studentTimetables;
	
	/**
	 * 
	 */
	public Student() {
	}

	/**
	 * @param person
	 */
	public Student(Person person) {
		this.person = person;
	}

	/**
	 * @param person
	 * @param balance
	 * @param grade
	 */
	public Student(Person person, long balance, int grade) {
		this.person = person;
		this.balance = balance;
		this.grade = grade;
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
	 * @return the balance
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(long balance) {
		this.balance = balance;
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
	 * @return the studentTimetables
	 */
	public Set<StudentTimetable> getStudentTimetables() {
		return studentTimetables;
	}

	/**
	 * @param studentTimetables the studentTimetables to set
	 */
	public void setStudentTimetables(Set<StudentTimetable> studentTimetables) {
		this.studentTimetables = studentTimetables;
	}
	
	
}
