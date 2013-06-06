/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.onlinetutoring.dao.ISubjectDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Answer;
import com.onlinetutoring.domain.Notification;
import com.onlinetutoring.domain.Question;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IQuestionService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Ssn
 * 
 */
@Service("questionService")
public class QuestionService extends BaseService<Question, Integer> implements
		IQuestionService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(QuestionService.class);
	private IQuestionDao questionDao;
	
	@Autowired
	@Qualifier("notificationDao")
	private INotificationDao notificationDao;

	@Autowired
	@Qualifier("questionDao")
	@Override
	public void setBaseDao(IBaseDao<Question, Integer> questionDao) {
		this.baseDao = questionDao;
		this.questionDao = (IQuestionDao) questionDao;
	}

	@Autowired
	@Qualifier("subjectDao")
	private ISubjectDao subjectDao;

	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	@Autowired
	@Qualifier("answerDao")
	private IAnswerDao answerDao;

	/*
	 * (non-Javadoc) publishQuestion
	 */
	@Override
	public boolean addQuestion(String email, String title, String content,
			String name, String pic_sn, String attach_sn, String attach_name) {
		Subject querySubject = new Subject();
		querySubject.setName(name);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		Question question = new Question(user, title, content, pic_sn,
				attach_sn, attach_name, subject);
		question.setAnswers(new HashSet<Answer>());
		return questionDao.save(question) != null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.onlinetutoring.service.IQuestionService#getQuestions(java.lang.String
	 * )
	 */
	@Override
	public List<Question> getQuestions(String email) {
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
//		Hibernate.initialize(user.getQuestions());
		return new ArrayList<Question>(user.getQuestions());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onlinetutoring.service.IQuestionService#getQuestionById(int)
	 */
	@Override
	public Question getQuestionById(int questionid) {
		return questionDao.get(questionid);
	}

	/*
	 * (non-Javadoc) makeComment
	 */
	@Override
	public boolean addAnswer(String email, String content, int questionid,
			String pic_sn) {
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		Question question = questionDao.get(questionid);

		Answer answer = new Answer(user, content, pic_sn, question);
		if(answerDao.save(answer) != null){
			question.setReply(question.getReply()+1);
			questionDao.update(question);
			notificationDao.save(new Notification(answer.getId(), 'a', question.getUser()));
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onlinetutoring.service.IQuestionService#getAnswers(int)
	 */
	@Override
	public List<Answer> getAnswers(int questionid) {
		return new ArrayList<Answer>(questionDao.get(questionid).getAnswers());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onlinetutoring.service.IQuestionService#getMyQuestions()
	 */
	@Override
	public List<Question> getMyQuestions() {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		String email = (String) session.get("email");

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		return new ArrayList<Question>(user.getQuestions());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.onlinetutoring.service.IQuestionService#getRealFileName(java.lang
	 * .String)
	 */
	@Override
	public String getRealFileName(String storename) {
		Question queryQuestion = new Question();
		queryQuestion.setAttachment(storename);
		Question question = questionDao.queryByCriteriaUnique(queryQuestion);

		return question != null ? question.getAttachname() : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.onlinetutoring.service.IQuestionService#getQuestionPageCount(int)
	 */
	@Override
	public int getQuestionPageCount(int pageSize) {
		int countAll = questionDao.countAll();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onlinetutoring.service.IQuestionService#getQuestionsByPage(int,
	 * int)
	 */
	@Override
	public List<Question> getQuestionsByPage(int pageNumber, int pageSize) {
		return questionDao.listAll(pageNumber, pageSize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.onlinetutoring.service.IQuestionService#getMyQuestionPageCount(int)
	 */
	@Override
	public int getMyQuestionPageCount(int pageSize) {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		String email = (String) session.get("email");

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		int countAll = user.getQuestions().size();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onlinetutoring.service.IQuestionService#getMyQuestions(int, int)
	 */
	@Override
	public List<Question> getMyQuestions(int pageNumber, int pageSize) {
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		String email = (String) session.get("email");

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);

		return questionDao
				.listAll(pageNumber, pageSize, "model.user.id = '" + user.getId() + "'");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onlinetutoring.service.IQuestionService#getCommentPageCount(int,
	 * int)
	 */
	@Override
	public int getCommentPageCount(int pageSize, int questionid) {
		Question question = questionDao.get(questionid);

		int countAll = question.getAnswers().size();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onlinetutoring.service.IQuestionService#getCommentsByPage(int,
	 * int, int)
	 */
	@Override
	public List<Answer> getCommentsByPage(int pageNumber, int pageSize, int questionid) {
		return answerDao.listAll(pageNumber, pageSize, "model.question.id = '" + questionid + "'");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.onlinetutoring.service.IQuestionService#deleteTopic(int)
	 */
	@Override
	public void deleteTopic(int questionid) {
		questionDao.delete(questionid);
	}
	@Override
	public void increaseView(int questionid) {
		Question question = questionDao.get(questionid);
		question.setView(question.getView()+1);
		questionDao.update(question);
	}
}
