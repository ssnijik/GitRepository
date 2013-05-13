/**
 * 
 */
package com.onlinetutoring.service;

import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.NotificationDao;
import com.onlinetutoring.dao.PersonDao;

/**
 * @author Ssn
 *
 */
@Service
public class UserService {
	private PersonDao personDao;
	private NotificationDao notificationDao;

}
