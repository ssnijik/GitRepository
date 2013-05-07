/**
 * 
 */
package com.onlinetutoring.pojo;

import java.util.Set;

/**
 * @author Ssn
 *
 */
public class Arrangement {

	private long id;
	
	private Tutor tutor;
	
	private Course course;
	
	private int score;

	private Set<Timetable> timetables;
	
	/**
	 * 
	 */
	public Arrangement() {
	}

	/**
	 * @param tutor
	 * @param course
	 */
	public Arrangement(Tutor tutor, Course course) {
		this.tutor = tutor;
		this.course = course;
	}

	/**
	 * @param tutor
	 * @param course
	 * @param score
	 */
	public Arrangement(Tutor tutor, Course course, int score) {
		this.tutor = tutor;
		this.course = course;
		this.score = score;
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
	 * @return the tutor
	 */
	public Tutor getTutor() {
		return tutor;
	}

	/**
	 * @param tutor the tutor to set
	 */
	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the timetables
	 */
	public Set<Timetable> getTimetables() {
		return timetables;
	}

	/**
	 * @param timetables the timetables to set
	 */
	public void setTimetables(Set<Timetable> timetables) {
		this.timetables = timetables;
	}
	
	
}
