/**
 * 
 */
package com.onlinetutoring.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.util.ConditionQuery;
import com.onlinetutoring.dao.util.OrderBy;
import com.onlinetutoring.utility.Assert;
import com.onlinetutoring.utility.page.PageUtil;

/**
 * @author Ssn
 * 
 */
public abstract class BaseDao<M extends Serializable, PK extends Serializable>
		implements IBaseDao<M, PK> {

	protected static final Logger LOGGER = LoggerFactory
			.getLogger(BaseDao.class);

	private final Class<M> entityClass;
	private final String HQL_LIST_ALL;
	private final String HQL_COUNT_ALL;
	private final String HQL_OPTIMIZE_PRE_LIST_ALL;
	private final String HQL_OPTIMIZE_NEXT_LIST_ALL;
	private final String HQL_WHERE_LIST_ALL;
	private final String HQL_ORDER_BY;
	private final String HQL_UPDATE;

	private String pkName = null;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		this.entityClass = (Class<M>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Field[] fields = this.entityClass.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(Id.class)) {
				this.pkName = f.getName();
			}
		}

		Assert.notNull(pkName);
		// TODO @Entity name not null
		HQL_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " order by " + pkName + " desc";
		HQL_OPTIMIZE_PRE_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " where " + pkName + " > ? order by " + pkName + " asc";
		HQL_OPTIMIZE_NEXT_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " where " + pkName + " < ? order by " + pkName + " desc";
		HQL_COUNT_ALL = " select count(*) from "
				+ this.entityClass.getSimpleName();
		HQL_WHERE_LIST_ALL = "from " + this.entityClass.getSimpleName()
				+ " as model where ";
		HQL_UPDATE = "update " + this.entityClass.getSimpleName()
				+ " as model ";
		HQL_ORDER_BY = " order by model." + pkName + " desc";
	}

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		// 浜嬪姟蹇呴』鏄紑鍚殑(Required)锛屽惁鍒欒幏鍙栦笉鍒�
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK save(M model) {
		return (PK) getSession().save(model);
	}

	@Override
	public void saveOrUpdate(M model) {
		getSession().saveOrUpdate(model);
	}

	@Override
	public void update(M model) {
		getSession().update(model);

	}

	@Override
	public void merge(M model) {
		getSession().merge(model);
	}

	@Override
	public void delete(PK id) {
		getSession().delete(this.get(id));

	}

	@Override
	public void deleteObject(M model) {
		getSession().delete(model);

	}

	@Override
	public boolean exists(PK id) {
		return get(id) != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public M get(PK id) {
		return (M) getSession().get(this.entityClass, id);
	}

	@Override
	public int countAll() {
		Long total = aggregate(HQL_COUNT_ALL);
		return total.intValue();
	}

	@Override
	public List<M> listAll() {
		return list(HQL_LIST_ALL);
	}

	@Override
	public int update(String condition) {
		Query query = getSession().createQuery(HQL_UPDATE + condition);
		return query.executeUpdate();
	}

	@Override
	public List<M> listAll(String condition) {
		return list(HQL_WHERE_LIST_ALL + condition + HQL_ORDER_BY);
	}

	@Override
	public List<M> listAll(int pn, int pageSize) {
		return list(HQL_LIST_ALL, pn, pageSize, new Object[] {});
	}

	@Override
	public List<M> listAll(int pn, int pageSize, String condition) {
		return list(HQL_WHERE_LIST_ALL + condition + HQL_ORDER_BY, pn,
				pageSize, new Object[] {});
	}

	@Override
	public List<M> listAllWithHql(int pn, int pageSize, String hql) {
		return list(hql, pn, pageSize, new Object[] {});
	}

	@Override
	public List<M> pre(PK pk, int pn, int pageSize) {
		if (pk == null) {
			return list(HQL_LIST_ALL, pn, pageSize, new Object[] {});
		}
		// 鍊掑簭锛岄噸鎺�
		List<M> result = this.list(HQL_OPTIMIZE_PRE_LIST_ALL, 1, pageSize,
				new Object[] { pk });
		Collections.reverse(result);
		return result;
	}

	@Override
	public List<M> next(PK pk, int pn, int pageSize) {
		if (pk == null) {
			return list(HQL_LIST_ALL, pn, pageSize, new Object[] {});
		}
		return list(HQL_OPTIMIZE_NEXT_LIST_ALL, 1, pageSize,
				new Object[] { pk });
	}

	@Override
	public void flush() {
		getSession().flush();
	}

	@Override
	public void clear() {
		getSession().clear();
	}

	protected long getIdResult(String hql, Object... paramlist) {
		long result = -1;
		List<?> list = list(hql, paramlist);
		if (list != null && list.size() > 0) {
			return ((Number) list.get(0)).longValue();
		}
		return result;
	}

	protected List<M> listSelf(final String hql, final int pn,
			final int pageSize, final Object... paramlist) {
		return this.<M> list(hql, pn, pageSize, paramlist);
	}

	/**
	 * for in
	 */
	@SuppressWarnings("unchecked")
	protected <T> List<T> listWithIn(final String hql, final int start,
			final int length, final Map<String, Collection<?>> map,
			final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		setParameters(query, paramlist);
		for (Entry<String, Collection<?>> e : map.entrySet()) {
			query.setParameterList(e.getKey(), e.getValue());
		}
		if (start > -1 && length > -1) {
			query.setMaxResults(length);
			if (start != 0) {
				query.setFirstResult(start);
			}
		}
		List<T> results = query.list();
		return results;
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> list(final String hql, final int pn,
			final int pageSize, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		setParameters(query, paramlist);
		if (pn > -1 && pageSize > -1) {
			query.setMaxResults(pageSize);
			int start = PageUtil.getPageStart(pn, pageSize);
			if (start != 0) {
				query.setFirstResult(start);
			}
		}
		if (pn < 0) {
			query.setFirstResult(0);
		}
		List<T> results = query.list();
		return results;
	}

	/**
	 * 鏍规嵁鏌ヨ鏉′欢杩斿洖鍞竴涓�潯璁板綍
	 */
	@SuppressWarnings("unchecked")
	protected <T> T unique(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		setParameters(query, paramlist);
		return (T) query.setMaxResults(1).uniqueResult();
	}

	/**
	 * 
	 * for in
	 */
	@SuppressWarnings("unchecked")
	protected <T> T aggregate(final String hql,
			final Map<String, Collection<?>> map, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		if (paramlist != null) {
			setParameters(query, paramlist);
			for (Entry<String, Collection<?>> e : map.entrySet()) {
				query.setParameterList(e.getKey(), e.getValue());
			}
		}

		return (T) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	protected <T> T aggregate(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		setParameters(query, paramlist);

		return (T) query.uniqueResult();

	}

	/**
	 * 鎵ц鎵瑰鐞嗚鍙�濡�涔嬮棿insert, update, delete 绛�
	 */
	protected int execteBulk(final String hql, final Object... paramlist) {
		Query query = getSession().createQuery(hql);
		setParameters(query, paramlist);
		Object result = query.executeUpdate();
		return result == null ? 0 : ((Integer) result).intValue();
	}

	protected int execteNativeBulk(final String natvieSQL,
			final Object... paramlist) {
		Query query = getSession().createSQLQuery(natvieSQL);
		setParameters(query, paramlist);
		Object result = query.executeUpdate();
		return result == null ? 0 : ((Integer) result).intValue();
	}

	protected <T> List<T> list(final String sql, final Object... paramlist) {
		return list(sql, -1, -1, paramlist);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> listByNative(final String nativeSQL, final int pn,
			final int pageSize, final List<Entry<String, Class<?>>> entityList,
			final List<Entry<String, Type>> scalarList,
			final Object... paramlist) {

		SQLQuery query = getSession().createSQLQuery(nativeSQL);
		if (entityList != null) {
			for (Entry<String, Class<?>> entity : entityList) {
				query.addEntity(entity.getKey(), entity.getValue());
			}
		}
		if (scalarList != null) {
			for (Entry<String, Type> entity : scalarList) {
				query.addScalar(entity.getKey(), entity.getValue());
			}
		}

		setParameters(query, paramlist);

		if (pn > -1 && pageSize > -1) {
			query.setMaxResults(pageSize);
			int start = PageUtil.getPageStart(pn, pageSize);
			if (start != 0) {
				query.setFirstResult(start);
			}
		}
		List<T> result = query.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	protected <T> T aggregateByNative(final String natvieSQL,
			final List<Entry<String, Type>> scalarList,
			final Object... paramlist) {
		SQLQuery query = getSession().createSQLQuery(natvieSQL);
		if (scalarList != null) {
			for (Entry<String, Type> entity : scalarList) {
				query.addScalar(entity.getKey(), entity.getValue());
			}
		}

		setParameters(query, paramlist);

		Object result = query.uniqueResult();
		return (T) result;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> list(ConditionQuery query, OrderBy orderBy,
			final int pn, final int pageSize) {
		Criteria criteria = getSession().createCriteria(this.entityClass);
		query.build(criteria);
		orderBy.build(criteria);
		int start = PageUtil.getPageStart(pn, pageSize);
		if (start != 0) {
			criteria.setFirstResult(start);
		}
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> list(Criteria criteria) {
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public <T> T unique(Criteria criteria) {
		return (T) criteria.uniqueResult();
	}

	public <T> List<T> list(DetachedCriteria criteria) {
		return list(criteria.getExecutableCriteria(getSession()));
	}

	@SuppressWarnings("unchecked")
	public <T> T unique(DetachedCriteria criteria) {
		return (T) unique(criteria.getExecutableCriteria(getSession()));
	}

	protected void setParameters(Query query, Object[] paramlist) {
		if (paramlist != null) {
			for (int i = 0; i < paramlist.length; i++) {
				if (paramlist[i] instanceof Date) {
					// TODO 闅鹃亾杩欐槸bug 浣跨敤setParameter涓嶈锛燂紵
					query.setTimestamp(i, (Date) paramlist[i]);
				} else {
					query.setParameter(i, paramlist[i]);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> queryByCriteria(Object example) {
		return getSession().createCriteria(example.getClass())
				.add(Example.create(example)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public M queryByCriteriaUnique(Object example) {
		return (M) getSession().createCriteria(example.getClass())
				.add(Example.create(example)).uniqueResult();
	}

}