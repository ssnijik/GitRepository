/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinetutoring.pojo.Person;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
public class PersonDao {
	/**
	 * Add Person
	 * @param p
	 * @return p
	 */
	public Person addPerson(Person p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed adding Person: "+ex.getMessage());
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
	 * Update Person
	 * @param p
	 */
	public void updatePerson(Person p) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			session.update(p);
			tx.commit();
		}
		catch (Exception ex) {
			System.err.println("Failed updating Person: "+ex.getMessage());
			if (tx != null) {
				tx.rollback();
			}
		}
		finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	/**
	 * Remove Person
	 * @param personId
	 */
	public void removePerson(int personId) {
		
	}
}
