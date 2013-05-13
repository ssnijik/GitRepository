/**
 * 
 */
package com.onlinetutoring.service;

import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.ArrangementDao;
import com.onlinetutoring.dao.CourseDao;
import com.onlinetutoring.dao.TimetableDao;
import com.onlinetutoring.dao.TutorDao;

/**
 * @author Ssn
 *
 */
@Service
public class CourseService {

	private TutorDao tutorDao;
	private CourseDao courseDao;
	private ArrangementDao arrangementDao;
	private TimetableDao timetableDao;
}
