package com.tutoring.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tutoring.entity.Subject;

public class SubjectDAOImpl extends HibernateDaoSupport implements SubjectDAO{

	@Override
	public Subject getSubjectByName(String name) {
		// TODO Auto-generated method stub
		List<?> subjectlist = this.getHibernateTemplate().find("from Subject where name='"+name+"'");
		if(subjectlist.size()>0)
		{
			Subject subject = (Subject) subjectlist.get(0);
			return subject;
		}
		else
			return null;
	}

}
