package com.onlinetutoring.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author Ssn
 * Hibernate Utility Class
 */

public class HibernateUtil {
	private static Configuration cfg;
	private static ServiceRegistry  sr;
	private static SessionFactory sessionFactory;
	
	static {
		try {
			//create new SessionFactory from hibernate.cfg.xml
			cfg = new Configuration().configure("/hibernate.cfg.xml");
			sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
			sessionFactory = cfg.buildSessionFactory(sr);
		}
		catch (Throwable ex) {
			// If something goes wrong, it will throw an exception
			System.err.println("Initial SessionFactory creation failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/**
	 * Open a new session
	 * @return Session
	 */
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	/**
	 * Close the current session
	 * @param session
	 */
	
	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
