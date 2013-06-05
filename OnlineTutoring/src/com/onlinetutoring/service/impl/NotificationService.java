/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.INotificationDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Notification;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.INotificationService;

/**
 * @author Ssn
 *
 */
@Service("notificationService")
public class NotificationService extends BaseService<Notification, Integer> implements INotificationService{

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
	private INotificationDao notificationDao;

	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;
	
    @Autowired
    @Qualifier("notificationDao")
    @Override
    public void setBaseDao(IBaseDao<Notification, Integer> notificationDao) {
        this.baseDao = notificationDao;
        this.notificationDao = (INotificationDao) notificationDao;
    }
    @Override
    public boolean addNotification(int id, int type, String email){
    	User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
    	return notificationDao.save(new Notification(id, type, user)) != null;
    }
    @Override
    public List<Notification> getNotification(String email){
    	User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
		List<Notification> notificationList = new ArrayList<Notification>(user.getNotifications());
		
		user.getNotifications().clear();
		
		userDao.update(user);
		
		return notificationList;
		
    }
    @Override
    public void deleteNotification(String email){
    	User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		
		user.getNotifications().clear();
		
		userDao.update(user);
    }
}
