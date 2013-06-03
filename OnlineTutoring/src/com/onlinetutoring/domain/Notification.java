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
public class Notification  extends AbstractModel {

	@Id
	private int id;
	
	private int notification_id;
	
	private Date time;
	
	private int type;
	
	private User user;

	/**
	 * 
	 */
	public Notification() {
	}

	/**
	 * @param notification_id
	 * @param type
	 * @param user
	 */
	public Notification(int notification_id, int type, User user) {
		this.notification_id = notification_id;
		this.type = type;
		this.user = user;
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
	 * @return the notification_id
	 */
	public int getNotification_id() {
		return notification_id;
	}

	/**
	 * @param notification_id the notification_id to set
	 */
	public void setNotification_id(int notification_id) {
		this.notification_id = notification_id;
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
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
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

	
}
