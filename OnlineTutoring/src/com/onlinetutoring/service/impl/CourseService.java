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
import com.onlinetutoring.dao.ICourseDao;
import com.onlinetutoring.dao.impl.CourseDao;
import com.onlinetutoring.domain.Course;
import com.onlinetutoring.service.ICourseService;

/**
 * @author Ssn
 *
 */
@Service("courseService")
public class CourseService extends BaseService<Course, Integer> implements ICourseService{

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseService.class);
	private ICourseDao iCourseDao;

    @Autowired
    @Qualifier("courseDao")
    @Override
    public void setBaseDao(IBaseDao<Course, Integer> iCourseDao) {
        this.baseDao = iCourseDao;
        this.iCourseDao = (ICourseDao) iCourseDao;
    }
}
