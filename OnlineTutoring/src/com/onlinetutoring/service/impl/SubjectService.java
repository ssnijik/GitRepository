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
import com.onlinetutoring.dao.ISubjectDao;
import com.onlinetutoring.dao.impl.SubjectDao;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.service.ISubjectService;

/**
 * @author Ssn
 *
 */
@Service("subjectService")
public class SubjectService extends BaseService<Subject, Integer> implements ISubjectService{

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectService.class);
	private ISubjectDao iSubjectDao;

    @Autowired
    @Qualifier("subjectDao")
    @Override
    public void setBaseDao(IBaseDao<Subject, Integer> iSubjectDao) {
        this.baseDao = iSubjectDao;
        this.iSubjectDao = (ISubjectDao) iSubjectDao;
    }
}
