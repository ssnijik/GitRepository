/**
 * 
 */
package com.onlinetutoring.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Id;


/**
 * @author Ssn
 *
 */
public class Question  extends AbstractModel {

	@Id
	private int id;
	
	private User user;
	
	private String title;
	
	private String content;
	
	private Date time;
	
	private int view;
	
	private int reply;
	
	private String picture;
	
	private String attachment;
	
	private String attachname;
	
	private Subject subject;
	
	private Set<Answer> answers;

	/**
	 * 
	 */
	public Question() {
	}

	/**
	 * @param user
	 * @param title
	 * @param content
	 * @param subject
	 */
	public Question(User user, String title, String content, Subject subject) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.subject = subject;
	}

	/**
	 * @param user
	 * @param title
	 * @param content
	 * @param picture
	 * @param attachment
	 * @param attachname
	 * @param subject
	 */
	public Question(User user, String title, String content, String picture,
			String attachment, String attachname, Subject subject) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.attachment = attachment;
		this.attachname = attachname;
		this.subject = subject;
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
	 * @return the attachment
	 */
	public String getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
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
	 * @return the attachname
	 */
	public String getAttachname() {
		return attachname;
	}

	/**
	 * @param attachname the attachname to set
	 */
	public void setAttachname(String attachname) {
		this.attachname = attachname;
	}

}
