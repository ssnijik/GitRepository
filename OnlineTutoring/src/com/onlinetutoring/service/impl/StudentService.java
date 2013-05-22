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
import com.onlinetutoring.dao.IStudentDao;
import com.onlinetutoring.dao.impl.StudentDao;
import com.onlinetutoring.domain.Student;
import com.onlinetutoring.service.IStudentService;

/**
 * @author Ssn
 *
 */
@Service("studentService")
public class StudentService extends BaseService<Student, Integer> implements IStudentService{

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	private IStudentDao iStudentDao;

    @Autowired
    @Qualifier("studentDao")
    @Override
    public void setBaseDao(IBaseDao<Student, Integer> iStudentDao) {
        this.baseDao = iStudentDao;
        this.iStudentDao = (IStudentDao) iStudentDao;
    }
}
