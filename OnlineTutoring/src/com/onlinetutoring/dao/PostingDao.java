/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Posting;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class PostingDao {
	/**
	 * Add Posting
	 * @param p
	 * @return p
	 */
	public Posting addPosting(Posting p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Posting: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return p;
	}
	
	/**
	 * Update Posting
	 * @param p
	 */
	public void updatePosting(Posting p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(p);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Posting: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Posting
	 * @param postingId
	 */
	public void removePosting(int postingId) {
		
	}
}
