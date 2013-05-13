/**
 * 
 */
package com.onlinetutoring.dao;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
/**
 * @author Ssn
 *
 */
public class BaseDao<T> {

	private Class<T> entityClass;
	@Autowired
	private HibernateTemplate hibernateTemplete;
	
	public BaseDao () {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class)params[0];
	}
	
	public T load (Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}
	
	public T get (Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}
	
	public List<T> loadAll () {
		return getHibernateTemplate().loadAll(entityClass);
	}
	
	public Serializable save (T entity) {
		return getHibernateTemplate().save(entity);
	}
	
	public void remove (T entity) {
		getHibernateTemplate().delete(entity);
	}
	
	public void update (T entity) {
		getHibernateTemplate().update(entity);
	}
	
	public List find (String hql) {
		return getHibernateTemplate().find(hql);
	}
	
	public List find (String hql, Object[] params) {
		return getHibernateTemplate().find(hql, params);
	}
	
	public void initialize (Object entity) {
		getHibernateTemplate().initialize(entity);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplete;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplete = hibernateTemplate;
	}
	
}
