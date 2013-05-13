/**
 * 
 */
package com.onlinetutoring.service;

import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.PersonDao;
import com.onlinetutoring.dao.TutorDao;

/**
 * @author Ssn
 *
 */
@Service
public class TutorService {

	private PersonDao personDao;
	private TutorDao tutorDao;
}
