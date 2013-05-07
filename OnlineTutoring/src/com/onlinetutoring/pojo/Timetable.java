/**
 * 
 */
package com.onlinetutoring.pojo;

import java.util.Date;
import java.util.Set;

/**
 * @author Ssn
 *
 */
public class Timetable {

	private long id;
	
	private Arrangement arrangement;
	
	private Date startTime;
	
	private Date endTime;

	private Set<StudentTimetable> studentTimetables;
	
	/**
	 * 
	 */
	public Timetable() {
	}

	/**
	 * @param arrangement
	 */
	public Timetable(Arrangement arrangement) {
		this.arrangement = arrangement;
	}

	/**
	 * @param arrangement
	 * @param startTime
	 * @param endTime
	 */
	public Timetable(Arrangement arrangement, Date startTime, Date endTime) {
		this.arrangement = arrangement;
		this.startTime = startTime;
		this.endTime = endTime;
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
	 * @return the arrangement
	 */
	public Arrangement getArrangement() {
		return arrangement;
	}

	/**
	 * @param arrangement the arrangement to set
	 */
	public void setArrangement(Arrangement arrangement) {
		this.arrangement = arrangement;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
