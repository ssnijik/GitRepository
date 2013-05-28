package com.tutoring.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PageDAOImpl extends HibernateDaoSupport implements PageDAO{

	@Override
	public List<?> findByPage(final String hql,final int offset,final int pageSize) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().executeFind(new HibernateCallback(){
			
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				System.out.println("offset:"+offset+";pagesize:"+pageSize);
				return session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize).list();
			}});
	}

	@Override
	public int getPageCount(final String nameOfEntity,final String whereClause) {
		// TODO Auto-generated method stub

		//return (Integer)this.getHibernateTemplate().iterate("select count(*) from "+nameOfEntity).next();
		//Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select count(*) from "+nameOfEntity);
		//return (Integer)query.uniqueResult();
		return this.getHibernateTemplate().execute(new HibernateCallback<Integer>(){

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("select count(*) from "+nameOfEntity+" "+whereClause);
				return ((Number)query.uniqueResult()).intValue();
			}
			
		});
	}

	
	

}
