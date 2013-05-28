package com.tutoring.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tutoring.entity.Question;
import com.tutoring.entity.Subject;
import com.tutoring.entity.User;

public class QuestionDAOImpl extends HibernateDaoSupport implements QuestionDAO{

	@Override
	public void addQuestion(User user, String title, String content,
			Subject subject,String pic_sn, String attach_sn,String attach_name) {
		// TODO Auto-generated method stub
		Question question = new Question();
		question.setUser(user);
		question.setTitle(title);
		question.setContent(content);
		question.setSubject(subject);
		Timestamp date = new Timestamp((new Date()).getTime());
		question.setTime(date);
		question.setView(0);
		question.setReply(0);
		question.setPicture(pic_sn);
		question.setAttachment(attach_sn);
		question.setAttachname(attach_name);
		this.getHibernateTemplate().merge(question);
	}

	@Override
	public Question getQuestionById(int id) {
		// TODO Auto-generated method stub
		List<?> qlist = this.getHibernateTemplate().find("from Question where id="+id);
		if(qlist.size()>0)
		{
			Question q = (Question) qlist.get(0);
			return q;
		}
		else
			return null;
	}

	@Override
	public List<Question> getQuestionsByUser(User u) {
		// TODO Auto-generated method stub
		List<Question> qlist = new ArrayList<Question>();
		qlist.addAll(u.getQuestions());
		return qlist;
	}

	@Override
	public String getFileNameBySN(String sn) {
		// TODO Auto-generated method stub
		List<?> qlist = this.getHibernateTemplate().find("from Question where attachment_sn='"+sn+"'");
		if(qlist.size()>0)
		{
			Question q = (Question) qlist.get(0);
			return q.getAttachname();
		}
		return null;
	}

	@Override
	public int getPageNumber() {
		// TODO Auto-generated method stub
		return (Integer)this.getHibernateTemplate().iterate("select count(*) from Question as question").next();
	}

	@Override
	public void deleteQuestion(Question q) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().delete(q);
	}

}
