/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Person;
import com.onlinetutoring.pojo.Student;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class StudentDao {
	/**
	 * Add Student
	 * @param p
	 * @return p
	 */
	public Student addStudent(Student s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(s);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Student: "+ex.getMessage());
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
	 * Update Student
	 * @param p
	 */
	public void updateStudent(Student s) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(s);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Student: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Student
	 * @param studentId
	 */
	public void removeStudent(int studentId) {
		
	}
}
