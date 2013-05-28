package com.tutoring.biz;

import java.util.List;

import com.tutoring.entity.Question;


public interface TopicBiz {
	public void publishQuestion(String useremail, String title, String content, String name, String pic_sn,String attach_sn,String attach_name);
	public List<?> getQuestions(String email);
	public Question getQuestionById(int id);
	public void makeComment(String useremail, String content, int questionid, String pic_sn);
	public List<?> getAnswers(int topicid);
	public List<?> getMyQuestions();
	public String getRealFileName(String storename);
	public int getQuestionPageCount(int pageSize);
	public List<?> getQuestionsByPage(int pageNumber,int pageSize);
	public int getMyQuestionPageCount(int pageSize);
	public List<?> getMyQuestions(int pageNumber,int pageSize);
	public int getCommentPageCount(int pageSize, int topicid);
	public List<?> getCommentsByPage(int pageNumber, int pageSize, int topicid);
	public void deleteTopic(int id);
}
