/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Master;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class MasterDao {
	/**
	 * Add Master
	 * @param m
	 * @return m
	 */
	public Master addMaster(Master m) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(m);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Master: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return m;
	}
	
	/**
	 * Update Master
	 * @param m
	 */
	public void updateMaster(Master m) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(m);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Master: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Master
	 * @param masterId
	 */
	public void removeMaster(int masterId) {
		
	}
}
