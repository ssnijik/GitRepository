/**
 * 
 */
package com.onlinetutoring.service;

import java.util.List;

import com.onlinetutoring.domain.Notification;

/**
 * @author Ssn
 *
 */
public interface INotificationService extends IBaseService<Notification, Integer> {

	boolean addNotification(int id, int type, String email);

	List<Notification> getNotification(String email);

	void deleteNotification(String email);

}
