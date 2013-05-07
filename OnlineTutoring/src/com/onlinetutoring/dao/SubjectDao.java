/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Subject;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class SubjectDao {
	/**
	 * Add Subject
	 * @param s
	 * @return s
	 */
	public Subject addSubject(Subject s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Subject: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return s;
	}
	
	/**
	 * Update Subject
	 * @param s
	 */
	public void updateSubject(Subject s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(s);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Subject: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Subject
	 * @param subjectId
	 */
	public void removeSubject(int subjectId) {
		
	}
}
