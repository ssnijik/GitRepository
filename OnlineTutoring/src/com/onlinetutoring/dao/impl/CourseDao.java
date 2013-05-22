/**
 * 
 */
package com.onlinetutoring.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlinetutoring.dao.ICourseDao;
import com.onlinetutoring.domain.Course;

/**
 * @author Ssn
 *
 */
@Repository("courseDao")
public class CourseDao extends BaseDao<Course, Integer> implements ICourseDao{

	
}
