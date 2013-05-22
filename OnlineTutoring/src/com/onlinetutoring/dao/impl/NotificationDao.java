/**
 * 
 */
package com.onlinetutoring.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlinetutoring.dao.INotificationDao;
import com.onlinetutoring.domain.Notification;

/**
 * @author Ssn
 *
 */
@Repository("notificationDao")
public class NotificationDao extends BaseDao<Notification, Integer> implements INotificationDao{

}
