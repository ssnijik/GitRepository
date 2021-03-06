/**
 * 
 */
package com.tutoring.entity;

import java.util.Date;

import javax.persistence.Id;


/**
 * @author Ssn
 *
 */
public class Message  extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	private User sender;
	
	private User receiver;
	
	private Date time;
	
	private String content;

	/**
	 * 
	 */
	public Message() {
	}

	/**
	 * @param sender
	 * @param receiver
	 * @param content
	 */
	public Message(User sender, User receiver, String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}

	/**
	 * @param sender
	 * @param receiver
	 * @param time
	 * @param content
	 */
	public Message(User sender, User receiver, Date time, String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.time = time;
		this.content = content;
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
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**
	 * @return the receiver
	 */
	public User getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(User receiver) {
		this.receiver = receiver;
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
