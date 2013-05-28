package com.tutoring.dao;

import java.sql.SQLException;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tutoring.entity.Student;
import com.tutoring.entity.Tutor;
import com.tutoring.entity.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{

	@Override
	public String getPasswordByEmail(String email) {
		// TODO Auto-generated method stub
		System.out.println("before query");
		List<?> personList = this.getHibernateTemplate().find("from User where email='"+email+"'");
		System.out.println("after query");
		if(personList.size()>0)
		{
			User person = (User) personList.get(0);
			return person.getPassword();
		}
		else
			return null;
	}

	public void addUser(String email, String password,char type,String firstname, String lastname)
	{
		User person = new User();
		person.setEmail(email);
		person.setPassword(password);
		person.setFirstName(firstname);
		person.setLastName(lastname);
		person.setType(type);
		if(type=='1')
		{
			Student stu = new Student();
			stu.setUser(person);
			this.getHibernateTemplate().save(stu);
		}
		else if(type=='2')
		{
			Tutor tutor = new Tutor();
			tutor.setUser(person);
			this.getHibernateTemplate().save(tutor);
		}
			
		
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		List<?> personList = this.getHibernateTemplate().find("from User where email = '"+email+"'");
		if(personList.size()>0)
		{
			User person = (User) personList.get(0);
			return person;
		}
		else
			return null;
		
	}


	@Override
	public List<?> getQuestionsByEmail(final String email) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {  
            public Object doInHibernate(Session s)  
                    throws HibernateException, SQLException { 

            	//List<?> list = s.createFilter(user.getQuestions(), "").setFirstResult(1).setMaxResults(10).list();
            	//s.setFlushMode(FlushMode.AUTO); 
            	//List<?> list = (List<?>) user.getQuestions().iterator();
            	Query query = s.createQuery("from Question");
            
            	List<?> list = query.list();
            	//s.close();
            	return list;
            }  
        }); 
		
	}
	
	
}
