/**
 * 
 */
package com.onlinetutoring.service;

import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.PersonDao;
import com.onlinetutoring.dao.StudentDao;
import com.onlinetutoring.dao.StudentTimetableDao;

/**
 * @author Ssn
 *
 */
@Service
public class StudentService {

	private PersonDao personDao;
	private StudentDao studentDao;
	private StudentTimetableDao studentTimetableDao;
}
