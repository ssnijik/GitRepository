/**
 * 
 */
package com.onlinetutoring.service;

import java.util.List;

import com.onlinetutoring.domain.Answer;
import com.onlinetutoring.domain.Question;

/**
 * @author Ssn
 * 
 */
public interface IQuestionService extends IBaseService<Question, Integer> {

	public boolean addQuestion(String useremail, String title, String content,
			String name, String pic_sn, String attach_sn, String attach_name);

	public List<Question> getQuestions(String email);

	public Question getQuestionById(int id);

	public boolean addAnswer(String useremail, String content, int questionid,
			String pic_sn);

	public List<Answer> getAnswers(int topicid);

	public List<Question> getMyQuestions();

	public String getRealFileName(String storename);

	public int getQuestionPageCount(int pageSize);

	public List<Question> getQuestionsByPage(int pageNumber, int pageSize);

	public int getMyQuestionPageCount(int pageSize);

	public List<Question> getMyQuestions(int pageNumber, int pageSize);

	public int getCommentPageCount(int pageSize, int topicid);

	public List<Answer> getCommentsByPage(int pageNumber, int pageSize, int topicid);

	public void deleteTopic(int id);

	void increaseView(int id);
}
