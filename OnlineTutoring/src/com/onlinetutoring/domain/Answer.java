/**
 * 
 */
package com.onlinetutoring.domain;

import java.util.Date;

import javax.persistence.Id;

/**
 * @author Ssn
 *
 */
public class Answer  extends AbstractModel {

	@Id
	private int id;
	
	private User user;
	
	private String content;
	
	private Date time;
	
	private String picture;
	
	private Question question;

	/**
	 * 
	 */
	public Answer() {
	}

	/**
	 * @param user
	 * @param content
	 * @param question
	 */
	public Answer(User user, String content, Question question) {
		this.user = user;
		this.content = content;
		this.question = question;
	}



	/**
	 * @param user
	 * @param content
	 * @param picture
	 * @param question
	 */
	public Answer(User user, String content, String picture, Question question) {
		this.user = user;
		this.content = content;
		this.picture = picture;
		this.question = question;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
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
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}


	
	
}
