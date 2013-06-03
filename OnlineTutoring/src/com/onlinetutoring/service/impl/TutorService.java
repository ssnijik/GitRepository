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
import com.onlinetutoring.dao.ITutorDao;
import com.onlinetutoring.dao.impl.TutorDao;
import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.service.ITutorService;

/**
 * @author Ssn
 *
 */
@Service("tutorService")
public class TutorService extends BaseService<Tutor, Integer> implements ITutorService{

	private static final Logger LOGGER = LoggerFactory.getLogger(TutorService.class);
	private ITutorDao tutorDao;

    @Autowired
    @Qualifier("tutorDao")
    @Override
    public void setBaseDao(IBaseDao<Tutor, Integer> tutorDao) {
        this.baseDao = tutorDao;
        this.tutorDao = (ITutorDao) tutorDao;
    }
}
