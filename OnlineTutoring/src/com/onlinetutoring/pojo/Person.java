package com.onlinetutoring.pojo;

import java.util.Date;
import java.util.Set;

public class Person {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String phone;
	
	private Date birthday;
	
	private String cardNumber;
	
	private char type;
	
	private int score;
	
	private String avator;
	
	private Set<Tutor> tutors;
	
	private Set<Student> students;

	private Set<Person> hosts;
	
	private Set<Person> guests;
	
	private Set<Person> senders;
	
	private Set<Person> recipients;

	private Set<Master> masters;

	private Set<Posting> postings;
	
	/**
	 * Default constructor
	 */
	public Person() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 */
	public Person(String firstName, String lastName, String email,
			String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param phone
	 * @param birthday
	 * @param cardNumber
	 * @param type
	 * @param score
	 * @param avator
	 */
	public Person(String firstName, String lastName, String email,
			String password, String phone, Date birthday, String cardNumber,
			char type, int score, String avator) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.cardNumber = cardNumber;
		this.type = type;
		this.score = score;
		this.avator = avator;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * s for Student
	 * t for Tutor
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	/**
	 * s for Student
	 * t for Tutor
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
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
	 * @return the avator
	 */
	public String getAvator() {
		return avator;
	}



	/**
	 * @param avator the avator to set
	 */
	public void setAvator(String avator) {
		this.avator = avator;
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
	 * @return the students
	 */
	public Set<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	/**
	 * @return the hosts
	 */
	public Set<Person> getHosts() {
		return hosts;
	}

	/**
	 * @param hosts the hosts to set
	 */
	public void setHosts(Set<Person> hosts) {
		this.hosts = hosts;
	}

	/**
	 * @return the guests
	 */
	public Set<Person> getGuests() {
		return guests;
	}

	/**
	 * @param guests the guests to set
	 */
	public void setGuests(Set<Person> guests) {
		this.guests = guests;
	}

	/**
	 * @return the senders
	 */
	public Set<Person> getSenders() {
		return senders;
	}

	/**
	 * @param senders the senders to set
	 */
	public void setSenders(Set<Person> senders) {
		this.senders = senders;
	}

	/**
	 * @return the recipients
	 */
	public Set<Person> getRecipients() {
		return recipients;
	}

	/**
	 * @param recipients the recipients to set
	 */
	public void setRecipients(Set<Person> recipients) {
		this.recipients = recipients;
	}

	/**
	 * @return the masters
	 */
	public Set<Master> getMasters() {
		return masters;
	}

	/**
	 * @param masters the masters to set
	 */
	public void setMasters(Set<Master> masters) {
		this.masters = masters;
	}

	/**
	 * @return the postings
	 */
	public Set<Posting> getPostings() {
		return postings;
	}

	/**
	 * @param postings the postings to set
	 */
	public void setPostings(Set<Posting> postings) {
		this.postings = postings;
	}

	
	
	
}
