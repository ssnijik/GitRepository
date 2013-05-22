/**
 * 
 */
package com.onlinetutoring.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.User;

/**
 * @author Ssn
 *
 */
@Repository("userDao")
public class UserDao extends BaseDao<User, Integer> implements IUserDao{

}
