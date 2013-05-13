/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.onlinetutoring.pojo.Person;
import com.onlinetutoring.pojo.Student;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
@Repository
public class StudentDao extends BaseDao<Student> {

}
