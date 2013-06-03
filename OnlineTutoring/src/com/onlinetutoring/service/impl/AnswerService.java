/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IAnswerDao;
import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.IQuestionDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Answer;
import com.onlinetutoring.domain.Question;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IAnswerService;

/**
 * @author Ssn
 * 
 */
@Service("answerService")
public class AnswerService extends BaseService<Answer, Integer> implements
		IAnswerService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(AnswerService.class);
	private IAnswerDao answerDao;

	@Autowired
	@Qualifier("answerDao")
	@Override
	public void setBaseDao(IBaseDao<Answer, Integer> answerDao) {
		this.baseDao = answerDao;
		this.answerDao = (IAnswerDao) answerDao;
	}

	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	@Autowired
	@Qualifier("questionDao")
	private IQuestionDao questionDao;

	public boolean addAnswer(String useremail, String content,
			 String pic_sn, int questionid) {

		User queryUser = new User();
		queryUser.setEmail(useremail);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
		Question question = questionDao.get(questionid);
		
		Answer answer = new Answer(user, content, pic_sn, question);
		if(answerDao.save(answer) != null){
			question.setReply(question.getReply()+1);
			questionDao.update(question);
			return true;
		}
		return false;

	}

	public List<Answer> getAnswers(String email) {
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		return new ArrayList<Answer>(user.getAnswers());
	}

	public Answer getAnswerById(int id) {
		return answerDao.get(id);
	}

}
