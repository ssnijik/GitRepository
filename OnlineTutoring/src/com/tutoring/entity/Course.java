/**
 * 
 */
package com.tutoring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Id;


/**
 * @author Ssn
 *
 */
public class Course  extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	private Date startTime;
	
	private Date endTime;
	
	private int duration;
	
	private int price;
	
	private String name;
	
	private String description;
	
	//evaluation by tutor
	private int ebta;
	
	private int ebtb;
	
	private int ebtc;
	
	//evaluation by student
	private int ebsa;
	
	private int ebsb;
	
	private int ebsc;
	
	private String evaluation;
	
	private Student student;
	
	private Tutor tutor;
	
	private Subject subject;
	
	private Set<Student> applications;

	/**
	 * 
	 */
	public Course() {
	}

	/**
	 * @param startTime
	 * @param endTime
	 * @param duration
	 * @param tutor
	 * @param price
	 * @param name
	 * @param description
	 * @param subject
	 * @param ebta
	 * @param ebtb
	 * @param ebtc
	 * @param ebsa
	 * @param ebsb
	 * @param ebsc
	 */
	public Course(Date startTime, Date endTime, int duration, Tutor tutor,
			int price, String name, String description, Subject subject,
			int ebta, int ebtb, int ebtc, int ebsa, int ebsb, int ebsc) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.tutor = tutor;
		this.price = price;
		this.name = name;
		this.description = description;
		this.subject = subject;
		this.ebta = ebta;
		this.ebtb = ebtb;
		this.ebtc = ebtc;
		this.ebsa = ebsa;
		this.ebsb = ebsb;
		this.ebsc = ebsc;
	}

	/**
	 * @param startTime
	 * @param endTime
	 * @param duration
	 * @param student
	 * @param tutor
	 * @param price
	 * @param name
	 * @param description
	 * @param subject
	 * @param ebta
	 * @param ebtb
	 * @param ebtc
	 * @param ebsa
	 * @param ebsb
	 * @param ebsc
	 * @param evaluation
	 */
	public Course(Date startTime, Date endTime, int duration, Student student,
			Tutor tutor, int price, String name, String description,
			Subject subject, int ebta, int ebtb, int ebtc, int ebsa, int ebsb,
			int ebsc, String evaluation) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.student = student;
		this.tutor = tutor;
		this.price = price;
		this.name = name;
		this.description = description;
		this.subject = subject;
		this.ebta = ebta;
		this.ebtb = ebtb;
		this.ebtc = ebtc;
		this.ebsa = ebsa;
		this.ebsb = ebsb;
		this.ebsc = ebsc;
		this.evaluation = evaluation;
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
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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
	 * @return the ebta
	 */
	public int getEbta() {
		return ebta;
	}

	/**
	 * @param ebta the ebta to set
	 */
	public void setEbta(int ebta) {
		this.ebta = ebta;
	}

	/**
	 * @return the ebtb
	 */
	public int getEbtb() {
		return ebtb;
	}

	/**
	 * @param ebtb the ebtb to set
	 */
	public void setEbtb(int ebtb) {
		this.ebtb = ebtb;
	}

	/**
	 * @return the ebtc
	 */
	public int getEbtc() {
		return ebtc;
	}

	/**
	 * @param ebtc the ebtc to set
	 */
	public void setEbtc(int ebtc) {
		this.ebtc = ebtc;
	}

	/**
	 * @return the ebsa
	 */
	public int getEbsa() {
		return ebsa;
	}

	/**
	 * @param ebsa the ebsa to set
	 */
	public void setEbsa(int ebsa) {
		this.ebsa = ebsa;
	}

	/**
	 * @return the ebsb
	 */
	public int getEbsb() {
		return ebsb;
	}

	/**
	 * @param ebsb the ebsb to set
	 */
	public void setEbsb(int ebsb) {
		this.ebsb = ebsb;
	}

	/**
	 * @return the ebsc
	 */
	public int getEbsc() {
		return ebsc;
	}

	/**
	 * @param ebsc the ebsc to set
	 */
	public void setEbsc(int ebsc) {
		this.ebsc = ebsc;
	}

	/**
	 * @return the evaluation
	 */
	public String getEvaluation() {
		return evaluation;
	}

	/**
	 * @param evaluation the evaluation to set
	 */
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	/**
	 * @return the applications
	 */
	public Set<Student> getApplications() {
		return applications;
	}

	/**
	 * @param applications the applications to set
	 */
	public void setApplications(Set<Student> applications) {
		this.applications = applications;
	}



	
}
