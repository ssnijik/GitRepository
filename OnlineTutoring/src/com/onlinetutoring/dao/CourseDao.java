/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Course;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class CourseDao {
	/**
	 * Add Course
	 * @param c
	 * @return c
	 */
	public Course addCourse(Course c) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(c);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Course: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
		return c;
	}
	
	/**
	 * Update Course
	 * @param c
	 */
	public void updateCourse(Course c) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(c);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Course: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Course
	 * @param courseId
	 */
	public void removeCourse(int courseId) {
		
	}
}
