/**
 * 
 */
package com.onlinetutoring.pojo;

import java.util.Date;

/**
 * @author Ssn
 *
 */
public class Notification {

	private long id;
	
	private Person sender;
	
	private Person recipient;
	
	private Date time;
	
	private String content;

	/**
	 * 
	 */
	public Notification() {
	}
	

	/**
	 * @param sender
	 * @param recipient
	 * @param content
	 */
	public Notification(Person sender, Person recipient, String content) {
		this.sender = sender;
		this.recipient = recipient;
		this.content = content;
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
	 * @return the sender
	 */
	public Person getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(Person sender) {
		this.sender = sender;
	}


	/**
	 * @return the recipient
	 */
	public Person getRecipient() {
		return recipient;
	}


	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(Person recipient) {
		this.recipient = recipient;
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
	
	
}
