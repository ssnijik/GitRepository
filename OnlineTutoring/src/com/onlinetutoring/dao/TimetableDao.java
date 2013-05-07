/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Timetable;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class TimetableDao {
	/**
	 * Add Timetable
	 * @param t
	 * @return t
	 */
	public Timetable addTimetable(Timetable t) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(t);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Timetable: "+ex.getMessage());
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
	 * Update Timetable
	 * @param t
	 */
	public void updateTimetable(Timetable t) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(t);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Timetable: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Timetable
	 * @param timetableId
	 */
	public void removeTimetable(int timetableId) {
		
	}
}
