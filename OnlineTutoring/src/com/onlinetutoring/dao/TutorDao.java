/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Person;
import com.onlinetutoring.pojo.Tutor;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class TutorDao {
	/**
	 * Add Tutor
	 * @param t
	 * @return t
	 */
	public Tutor addTutor(Tutor t) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(t);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Tutor: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return t;
	}
	
	/**
	 * Update Tutor
	 * @param t
	 */
	public void updateTutor(Tutor t) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(t);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Tutor: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Tutor
	 * @param tutorId
	 */
	public void removeTutor(int tutorId) {
		
	}
}
