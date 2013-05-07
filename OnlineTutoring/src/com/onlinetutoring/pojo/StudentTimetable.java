/**
 * 
 */
package com.onlinetutoring.pojo;

/**
 * @author Ssn
 *
 */
public class StudentTimetable {

	private long id;
	
	private Student student;
	
	private Timetable timetable;
	
	private int score;
	
	private String remark;

	/**
	 * 
	 */
	public StudentTimetable() {
	}

	/**
	 * @param student
	 * @param timetable
	 */
	public StudentTimetable(Student student, Timetable timetable) {
		this.student = student;
		this.timetable = timetable;
	}

	/**
	 * @param student
	 * @param timetable
	 * @param score
	 * @param remark
	 */
	public StudentTimetable(Student student, Timetable timetable, int score,
			String remark) {
		this.student = student;
		this.timetable = timetable;
		this.score = score;
		this.remark = remark;
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
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the timetable
	 */
	public Timetable getTimetable() {
		return timetable;
	}

	/**
	 * @param timetable the timetable to set
	 */
	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
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
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
