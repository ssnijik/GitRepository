/**
 * 
 */
package com.onlinetutoring.pojo;

import java.util.Date;

/**
 * @author Ssn
 *
 */
public class Posting {

	private long id;
	
	private Person postedBy;
	
	private String title;
	
	private String content;
	
	private Date time;
	
	private Master master;

	/**
	 * 
	 */
	public Posting() {
	}

	/**
	 * @param postedBy
	 * @param title
	 * @param content
	 * @param master
	 */
	public Posting(Person postedBy, String title, String content, Master master) {
		this.postedBy = postedBy;
		this.title = title;
		this.content = content;
		this.master = master;
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
	 * @return the postedBy
	 */
	public Person getPostedBy() {
		return postedBy;
	}

	/**
	 * @param postedBy the postedBy to set
	 */
	public void setPostedBy(Person postedBy) {
		this.postedBy = postedBy;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the master
	 */
	public Master getMaster() {
		return master;
	}

	/**
	 * @param master the master to set
	 */
	public void setMaster(Master master) {
		this.master = master;
	}
	
	
}
