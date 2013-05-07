/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Arrangement;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class ArrangementDao {
	/**
	 * Add Arrangement
	 * @param a
	 * @return a
	 */
	public Arrangement addArrangement(Arrangement a) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(a);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Arrangement: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return a;
	}
	
	/**
	 * Update Arrangement
	 * @param a
	 */
	public void updateArrangement(Arrangement a) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(a);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Arrangement: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Arrangement
	 * @param arrangementId
	 */
	public void removeArrangement(int arrangementId) {
		
	}
}
