package com.tutoring.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tutoring.entity.Answer;
import com.tutoring.entity.Question;
import com.tutoring.entity.User;

public class AnswerDAOImpl extends HibernateDaoSupport implements AnswerDAO{

	@Override
	public void addAnswer(User user, String content, Question question, String pic_sn) {
		// TODO Auto-generated method stub
	
		Answer ans = new Answer();
		ans.setUser(user);
		ans.setContent(content);
		ans.setQuestion(question);
		Timestamp date = new Timestamp((new Date()).getTime());
		ans.setTime(date);
		ans.setPicture(pic_sn);
		this.getHibernateTemplate().merge(ans);
	}

	@Override
	public List<Answer> getAnswersByQuestion(Question q) {
		// TODO Auto-generated method stub
		
		List<Answer> list = new ArrayList<Answer>();
		list.addAll(q.getAnswers());
		return  list;
	}

}
