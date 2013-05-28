package com.tutoring.biz;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tutoring.dao.AnswerDAO;
import com.tutoring.dao.PageDAO;
import com.tutoring.dao.QuestionDAO;
import com.tutoring.dao.SubjectDAO;
import com.tutoring.dao.UserDAO;
import com.tutoring.entity.Question;
import com.tutoring.entity.Subject;
import com.tutoring.entity.User;

public class TopicBizImpl implements TopicBiz{

	QuestionDAO questionDAO;
	UserDAO userDAO;
	SubjectDAO subjectDAO;
	AnswerDAO answerDAO;
	PageDAO pageDAO;
	public void setPageDAO(PageDAO pageDAO) {
		this.pageDAO = pageDAO;
	}
	public void setAnswerDAO(AnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}
	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
	@Override
	public void publishQuestion(String useremail, String title, String content,
			String name, String pic_sn,String attach_sn,String attach_name) {
		// TODO Auto-generated method stub
		
		Subject subject = subjectDAO.getSubjectByName(name);
		User user = userDAO.getUserByEmail(useremail);
		questionDAO.addQuestion(user, title, content, subject,pic_sn,attach_sn,attach_name);
	}
	@Override
	public List<?> getQuestions(String email) {
		// TODO Auto-generated method stub
		return userDAO.getQuestionsByEmail(email);
	}
	@Override
	public Question getQuestionById(int id) {
		// TODO Auto-generated method stub
		
		return questionDAO.getQuestionById(id);
	}
	@Override
	public void makeComment(String useremail, String content, int questionid, String pic_sn) {
		// TODO Auto-generated method stub
		User user = userDAO.getUserByEmail(useremail);
		Question qt = questionDAO.getQuestionById(questionid);
		answerDAO.addAnswer(user, content, qt,pic_sn);
	}
	@Override
	public List<?> getAnswers(int topicid) {
		// TODO Auto-generated method stub
		Question q = questionDAO.getQuestionById(topicid);
		return answerDAO.getAnswersByQuestion(q);
	}
	@Override
	public List<?> getMyQuestions() {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		Map<String , Object> session = ac.getSession();
		String useremail = (String) session.get("email");
		User user = userDAO.getUserByEmail(useremail);
		
		return questionDAO.getQuestionsByUser(user);
	}
	@Override
	public String getRealFileName(String storename) {
		// TODO Auto-generated method stub
		String realname = questionDAO.getFileNameBySN(storename);
		return realname;
	}
	@Override
	public int getQuestionPageCount(int pageSize) {
		// TODO Auto-generated method stub
		int pagecount = pageDAO.getPageCount("Question","");
		
		if(pagecount%pageSize==0)
			return pagecount/pageSize;
		else
			return pagecount/pageSize+1;

	}
	@Override
	public List<?> getQuestionsByPage(int pageNumber,int pageSize) {
		// TODO Auto-generated method stub
		return pageDAO.findByPage("from Question", (pageNumber-1)*pageSize, pageSize);
	}
	@Override
	public int getMyQuestionPageCount(int pageSize) {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		Map<String , Object> session = ac.getSession();
		String useremail = (String) session.get("email");
		User user = userDAO.getUserByEmail(useremail);
		
		int pagecount = pageDAO.getPageCount("Question", "where user_id = "+user.getId());
		
		if(pagecount%pageSize==0)
			return pagecount/pageSize;
		else
			return pagecount/pageSize+1;
	}
	@Override
	public List<?> getMyQuestions(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		ActionContext ac = ActionContext.getContext();
		Map<String , Object> session = ac.getSession();
		String useremail = (String) session.get("email");
		User user = userDAO.getUserByEmail(useremail);
		
		return pageDAO.findByPage("from Question where user_id="+user.getId(), (pageNumber-1)*pageSize, pageSize);
	}
	@Override
	public int getCommentPageCount(int pageSize, int topicid) {
		// TODO Auto-generated method stub
		int pagecount = pageDAO.getPageCount("Answer", "where question_id = "+topicid);
		if(pagecount%pageSize == 0)
			return pagecount/pageSize;
		else
			return pagecount/pageSize+1;
	}
	@Override
	public List<?> getCommentsByPage(int pageNumber, int pageSize, int topicid) {
		// TODO Auto-generated method stub
		return pageDAO.findByPage("from Answer where question_id = "+topicid, (pageNumber-1)*pageSize, pageSize);
	}
	@Override
	public void deleteTopic(int id) {
		// TODO Auto-generated method stub
		//questionDAO.deleteQuestionById(id);
		
		Question q = questionDAO.getQuestionById(id);
		questionDAO.deleteQuestion(q);
	}
	

}
