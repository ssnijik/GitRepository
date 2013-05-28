package com.tutoring.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tutoring.entity.Student;
import com.tutoring.entity.User;

public class StudentDAOImpl extends HibernateDaoSupport implements StudentDAO{

	@Override
	public void addStudent(User u) {
		// TODO Auto-generated method stub
		Student stu = new Student();
		stu.setUser(u);
		this.getHibernateTemplate().merge(stu);
	}

}
