/**
 * 
 */
package com.onlinetutoring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.dao.impl.UserDao;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IUserService;

/**
 * @author Ssn
 *
 */
@Service("userService")
public class UserService extends BaseService<User, Integer> implements IUserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	private IUserDao iUserDao;

    @Autowired
    @Qualifier("userDao")
    @Override
    public void setBaseDao(IBaseDao<User, Integer> iUserDao) {
        this.baseDao = iUserDao;
        this.iUserDao = (IUserDao) iUserDao;
    }


}
