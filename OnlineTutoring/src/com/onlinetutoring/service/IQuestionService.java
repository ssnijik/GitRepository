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

	/**
	 * 根据本人email添加一个问题，函数原名publishQuestion
	 * @param useremail
	 * @param title
	 * @param content
	 * @param name
	 * @param pic_sn
	 * @param attach_sn
	 * @param attach_name
	 * @return
	 */
	public boolean addQuestion(String useremail, String title, String content,
			String name, String pic_sn, String attach_sn, String attach_name);

	/**
	 * 根据本人email获取本人所有问题
	 * @param email
	 * @return
	 */
	public List<Question> getQuestions(String email);

	/**
	 * 根据问题id获取问题
	 * @param id
	 * @return
	 */
	public Question getQuestionById(int id);

	/**
	 * 根据本人email和问题id添加回答，函数原名makeComment
	 * @param useremail
	 * @param content
	 * @param questionid
	 * @param pic_sn
	 * @return
	 */
	public boolean addAnswer(String useremail, String content, int questionid,
			String pic_sn);

	/**
	 * 根据问题id获取问题的所有答案
	 * @param topicid
	 * @return
	 */
	public List<Answer> getAnswers(int topicid);

	/**
	 * 获取本人所有问题
	 * @return
	 */
	public List<Question> getMyQuestions();

	/**
	 * 获取实际文件名
	 * @param storename
	 * @return
	 */
	public String getRealFileName(String storename);

	/**
	 * 获取所有问题分页页数
	 * @param pageSize
	 * @return
	 */
	public int getQuestionPageCount(int pageSize);

	/**
	 * 获取分页问题
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Question> getQuestionsByPage(int pageNumber, int pageSize);

	/**
	 * 获取本人问题分页页数
	 * @param pageSize
	 * @return
	 */
	public int getMyQuestionPageCount(int pageSize);

	/**
	 * 获取本人分页问题
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<Question> getMyQuestions(int pageNumber, int pageSize);

	/**
	 * 获取本人答案分页页数
	 * @param pageSize
	 * @param topicid
	 * @return
	 */
	public int getCommentPageCount(int pageSize, int topicid);

	/**
	 * 获取本人分页答案
	 * @param pageNumber
	 * @param pageSize
	 * @param topicid
	 * @return
	 */
	public List<Answer> getCommentsByPage(int pageNumber, int pageSize,
			int topicid);

	/**
	 * 根据问题id删除问题
	 * @param id
	 */
	public void deleteTopic(int id);

	/**
	 * 根据问题id增加查看数
	 * @param id
	 */
	void increaseView(int id);
}
