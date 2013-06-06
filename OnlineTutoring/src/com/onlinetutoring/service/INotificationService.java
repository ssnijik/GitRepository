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
public interface INotificationService extends
		IBaseService<Notification, Integer> {

	/**
	 * 添加一个通知
	 * @param id
	 * @param type
	 * @param email
	 * @return
	 */
	boolean addNotification(int id, int type, String email);

	/**
	 * 根据本人email获取本人通知
	 * @param email
	 * @return
	 */
	List<Notification> getNotification(String email);

	/**
	 * 根据通知id删除一个通知
	 * @param email
	 */
	void deleteNotification(String email);

}
