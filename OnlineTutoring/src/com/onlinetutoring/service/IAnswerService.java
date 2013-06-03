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

	List<Answer> getAnswers(String email);

	Answer getAnswerById(int id);

	List<Answer> getAnswers(int topicid);

	List<Answer> getAnswers();

	int getMyAnswerPageCount(int pageSize);

	List<Answer> getMyAnswersByPage(int pageNumber, int pageSize);

	void deleteAnswer(int id);

}
