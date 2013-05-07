/**
 * 
 */
package com.onlinetutoring.pojo;

import java.util.Date;
import java.util.Set;

/**
 * @author Ssn
 *
 */
public class Master {

	private long id;
	
	private Person postedBy;
	
	private String title;
	
	private String content;
	
	private Date time;
	
	private int view;
	
	private int reply;
	
	private Set<Posting> postings;


	/**
	 * 
	 */
	public Master() {
	}

	/**
	 * @param postedBy
	 * @param title
	 * @param content
	 */
	public Master(Person postedBy, String title, String content) {
		this.postedBy = postedBy;
		this.title = title;
		this.content = content;
	}

	/**
	 * @param postedBy
	 * @param title
	 * @param content
	 * @param view
	 * @param reply
	 */
	public Master(Person postedBy, String title, String content,
			int view, int reply) {
		this.postedBy = postedBy;
		this.title = title;
		this.content = content;
		this.view = view;
		this.reply = reply;
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
	 * @return the view
	 */
	public int getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(int view) {
		this.view = view;
	}

	/**
	 * @return the reply
	 */
	public int getReply() {
		return reply;
	}

	/**
	 * @param reply the reply to set
	 */
	public void setReply(int reply) {
		this.reply = reply;
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
