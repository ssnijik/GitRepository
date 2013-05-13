/**
 * 
 */
package com.onlinetutoring.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.onlinetutoring.pojo.Posting;
import com.onlinetutoring.utility.HibernateUtil;

/**
 * @author Ssn
 *
 */
@Repository
public class PostingDao extends BaseDao<Posting> {

}
