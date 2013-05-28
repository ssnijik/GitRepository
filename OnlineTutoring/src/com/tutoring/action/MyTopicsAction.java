package com.tutoring.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tutoring.biz.TopicBiz;

public class MyTopicsAction extends ActionSupport{

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
	public String execute() throws Exception{
		ActionContext ac = ActionContext.getContext();
		
		pageSize = 5;
		
		pageCount = topicBiz.getMyQuestionPageCount(pageSize);
		
		List<?> qlist = topicBiz.getMyQuestions(pageIndex, pageSize);//topicBiz.getMyQuestions();
		ac.put("questions", qlist);
		return SUCCESS;
	}
}
