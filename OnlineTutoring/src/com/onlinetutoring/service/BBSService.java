/**
 * 
 */
package com.onlinetutoring.service;

import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.MasterDao;
import com.onlinetutoring.dao.PersonDao;
import com.onlinetutoring.dao.PostingDao;

/**
 * @author Ssn
 *
 */
@Service
public class BBSService {

	private PersonDao personDao;
	private MasterDao masterDao;
	private PostingDao postingDao;
}
