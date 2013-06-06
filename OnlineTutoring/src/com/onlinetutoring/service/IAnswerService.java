/**
 * 
 */
package com.onlinetutoring.service;

import java.util.List;

import com.onlinetutoring.domain.Answer;

/**
 * @author Ssn
 * 
 */
public interface IAnswerService extends IBaseService<Answer, Integer> {

	boolean addAnswer(String useremail, String content, int questionid,
			String pic_sn);

	/**
	 * 返回本人的回答
	 * 
	 * @param email
	 * @return
	 */
	List<Answer> getAnswers(String email);

	/**
	 * 根据回答的id返回一个回答
	 * 
	 * @param id
	 * @return
	 */
	Answer getAnswerById(int id);

	/**
	 * 根据问题的id返回所有回答
	 * 
	 * 
	 * @param topicid
	 * @return
	 */
	List<Answer> getAnswers(int topicid);

	/**
	 * 根据actioncontext中的email 返回本人的回答
	 * 
	 * @return
	 */
	List<Answer> getAnswers();

	/**
	 * 根据actioncontext中的email 返回分页的页数
	 * 
	 * @param pageSize
	 * @return
	 */
	int getMyAnswerPageCount(int pageSize);

	/**
	 * 根据actioncontext中的email 分页返回本人的回答
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<Answer> getMyAnswersByPage(int pageNumber, int pageSize);

	/**
	 * 根据回答的id删除一个回答
	 * 
	 * @param id
	 */
	void deleteAnswer(int id);

	/**
	 * 返回分页的页数
	 * 
	 * @param email
	 * @param pageSize
	 * @return
	 */
	int getMyAnswerPageCount(String email, int pageSize);

	/**
	 * 分页返回本人的回答
	 * @param email
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<Answer> getMyAnswersByPage(String email, int pageNumber, int pageSize);

}
