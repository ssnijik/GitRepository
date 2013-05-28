package com.tutoring.action;


import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tutoring.biz.TopicBiz;
import com.tutoring.entity.Question;

public class TopicDetailAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageCount;
	private int pageSize;
	private int pageIndex=1;
	public int getPageIndex() {
		return pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	TopicBiz topicBiz;
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	private int topicid;
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int id) {
		this.topicid = id;
	}
	public String execute() throws Exception{
		
		Question q = topicBiz.getQuestionById(topicid);
		//System.out.println(q.getSubject());
		ActionContext ac = ActionContext.getContext();
		ac.getValueStack().push(q);
		//System.out.println(q.getPicture());
		pageSize = 5;
		pageCount = topicBiz.getCommentPageCount(pageSize,topicid);
		
		List<?> answers = topicBiz.getCommentsByPage(pageIndex, pageSize,topicid); //topicBiz.getAnswers(topicid);
		//System.out.println(answers.get(0).getUser().getFirstName());
		ac.put("answers", answers);
		return SUCCESS;
	}
}
