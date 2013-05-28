package com.tutoring.action;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tutoring.biz.TopicBiz;

public class AllTopicsAction extends ActionSupport{

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
	TopicBiz topicBiz;
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	public String execute() throws Exception{
		ActionContext ac = ActionContext.getContext();
		//Map<String, Object> session = ac.getSession();
		
		pageSize = 5;
		
		pageCount = topicBiz.getQuestionPageCount(pageSize);
		
		//String useremail = (String) session.get("email");
		List<?> qlist = topicBiz.getQuestionsByPage(pageIndex, pageSize);//topicBiz.getQuestions(useremail);
		
		
		System.out.println("pageIndex:"+pageIndex);
		
		ac.put("questions", qlist);
		//topicBiz.makeComment("panyan@gmail.com", "hello", 2);
		
		
		return SUCCESS;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

}
