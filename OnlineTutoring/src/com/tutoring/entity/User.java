package com.tutoring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Id;

public class User  extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String phone;
	
	private Date birthday;
	
	private String cardNumber;
	
	private char type;
	
	private Integer point;
	
	private String picture;
	
	private String school;
	
	private String cookie;
	
	private Tutor tutor;
	
	private Student student;

	private Set<User> friendsHaveMe;
	
	private Set<User> friendsIHave;
	
	private Set<Message> sends;
	
	private Set<Message> receives;

	private Set<Question> questions;

	private Set<Answer> answers;
	
	private Set<Notification> notifications;

	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param email
	 * @param password
	 * @param type
	 */
	public User(String email, String password, char type) {
		this.email = email;
		this.password = password;
		this.type = type;
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
	 * @param point
	 * @param picture
	 * @param school
	 * @param cookie
	 */
	public User(String firstName, String lastName, String email,
			String password, String phone, Date birthday, String cardNumber,
			char type, Integer point, String picture, String school, String cookie) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.birthday = birthday;
		this.cardNumber = cardNumber;
		this.type = type;
		this.point = point;
		this.picture = picture;
		this.school = school;
		this.cookie = cookie;
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
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(char type) {
		this.type = type;
	}

	/**
	 * @return the point
	 */
	public Integer getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}

	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * @return the cookie
	 */
	public String getCookie() {
		return cookie;
	}

	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie) {
		this.cookie = cookie;
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
	 * @return the friendsHaveMe
	 */
	public Set<User> getFriendsHaveMe() {
		return friendsHaveMe;
	}

	/**
	 * @param friendsHaveMe the friendsHaveMe to set
	 */
	public void setFriendsHaveMe(Set<User> friendsHaveMe) {
		this.friendsHaveMe = friendsHaveMe;
	}

	/**
	 * @return the friendsIHave
	 */
	public Set<User> getFriendsIHave() {
		return friendsIHave;
	}

	/**
	 * @param friendsIHave the friendsIHave to set
	 */
	public void setFriendsIHave(Set<User> friendsIHave) {
		this.friendsIHave = friendsIHave;
	}

	/**
	 * @return the sends
	 */
	public Set<Message> getSends() {
		return sends;
	}

	/**
	 * @param sends the sends to set
	 */
	public void setSends(Set<Message> sends) {
		this.sends = sends;
	}

	/**
	 * @return the receives
	 */
	public Set<Message> getReceives() {
		return receives;
	}

	/**
	 * @param receives the receives to set
	 */
	public void setReceives(Set<Message> receives) {
		this.receives = receives;
	}

	/**
	 * @return the questions
	 */
	public Set<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	/**
	 * @return the answers
	 */
	public Set<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * @return the notifications
	 */
	public Set<Notification> getNotifications() {
		return notifications;
	}

	/**
	 * @param notifications the notifications to set
	 */
	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	
	
	
}
