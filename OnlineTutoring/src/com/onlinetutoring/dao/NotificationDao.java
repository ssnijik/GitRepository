/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Notification;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class NotificationDao {
	/**
	 * Add Notification
	 * @param n
	 * @return n
	 */
	public Notification addNotification(Notification n) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(n);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Notification: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return n;
	}
	
	/**
	 * Update Notification
	 * @param n
	 */
	public void updateNotification(Notification n) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(n);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Notification: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Notification
	 * @param notificationId
	 */
	public void removeNotification(int notificationId) {
		
	}
}
