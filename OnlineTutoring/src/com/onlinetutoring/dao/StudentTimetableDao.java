/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.StudentTimetable;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class StudentTimetableDao {
	/**
	 * Add StudentTimetable
	 * @param st
	 * @return st
	 */
	public StudentTimetable addStudentTimetable(StudentTimetable st) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(st);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding StudentTimetable: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return st;
	}
	
	/**
	 * Update StudentTimetable
	 * @param st
	 */
	public void updateStudentTimetable(StudentTimetable st) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(st);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating StudentTimetable: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove StudentTimetable
	 * @param studentTimetableId
	 */
	public void removeStudentTimetable(int studentTimetableId) {
		
	}
}
