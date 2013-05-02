package com.onlinetutoring.pojo;

import java.util.Date;

public class Person {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String email;
	
	private String country;
	
	private String city;
	
	private String address;
	
	private String phone;
	
	private Date birthday;
	
	private int cardNumber;
	
	private char type;
	
	private int score;
	
	/**
	 * Default constructor
	 */
	public Person() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 */
	public Person(String firstName, String lastName, String password,
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 * @param country
	 * @param city
	 * @param address
	 * @param phone
	 * @param birthday
	 * @param cardNumber
	 * @param type
	 * @param score
	 */
	public Person(String firstName, String lastName, String password,
			String email, String country, String city, String address,
			String phone, Date birthday, int cardNumber, char type, int score) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.country = country;
		this.city = city;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;
		this.cardNumber = cardNumber;
		this.type = type;
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
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	public int getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(int cardNumber) {
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
	
	
}
