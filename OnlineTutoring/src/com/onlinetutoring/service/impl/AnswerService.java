/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IAnswerDao;
import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.INotificationDao;
import com.onlinetutoring.dao.IQuestionDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Answer;
import com.onlinetutoring.domain.Notification;
import com.onlinetutoring.domain.Question;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IAnswerService;
import com.opensymphony.xwork2.ActionContext;

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
	@Qualifier("notificationDao")
	private INotificationDao notificationDao;
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	@Autowired
	@Qualifier("questionDao")
	private IQuestionDao questionDao;

	@Override
	public boolean addAnswer(String email, String content, int questionid,
			String pic_sn) {

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		Question question = questionDao.get(questionid);

		Answer answer = new Answer(user, content, pic_sn, question);
		if (answerDao.save(answer) != null) {
			question.setReply(question.getReply() + 1);
			questionDao.update(question);
			notificationDao.save(new Notification(answer.getId(), 'a', question.getUser()));
			return true;
		}
		return false;

	}
	@Override
	public List<Answer> getAnswers(String email) {
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		return new ArrayList<Answer>(user.getAnswers());
	}
	@Override
	public Answer getAnswerById(int answerid) {
		return answerDao.get(answerid);
	}
	@Override
	public List<Answer> getAnswers(int questionid) {
		return new ArrayList<Answer>(questionDao.get(questionid).getAnswers());
	}
	@Override
	public List<Answer> getAnswers() {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		String email = (String) session.get("email");

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		return new ArrayList<Answer>(user.getAnswers());
	}
	@Override
	public int getMyAnswerPageCount(int pageSize) {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		String email = (String) session.get("email");

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		int countAll = user.getAnswers().size();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}
	@Override
	public List<Answer> getMyAnswersByPage(int pageNumber, int pageSize) {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		String email = (String) session.get("email");

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		return answerDao.listAll(pageNumber, pageSize,
				"model.user.id=" + user.getId());
	}
	@Override
	public void deleteAnswer(int answerid) {
		answerDao.delete(answerid);
	}

}
