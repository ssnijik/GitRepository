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
import com.onlinetutoring.dao.INotificationDao;
import com.onlinetutoring.dao.impl.NotificationDao;
import com.onlinetutoring.domain.Notification;
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
    @Qualifier("notificationDao")
    @Override
    public void setBaseDao(IBaseDao<Notification, Integer> notificationDao) {
        this.baseDao = notificationDao;
        this.notificationDao = (INotificationDao) notificationDao;
    }
}
