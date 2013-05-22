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
import com.onlinetutoring.dao.IAnswerDao;
import com.onlinetutoring.dao.impl.AnswerDao;
import com.onlinetutoring.domain.Answer;
import com.onlinetutoring.service.IAnswerService;

/**
 * @author Ssn
 *
 */
@Service("answerService")
public class AnswerService extends BaseService<Answer, Integer> implements IAnswerService{

	private static final Logger LOGGER = LoggerFactory.getLogger(AnswerService.class);
	private IAnswerDao iAnswerDao;

    @Autowired
    @Qualifier("answerDao")
    @Override
    public void setBaseDao(IBaseDao<Answer, Integer> iAnswerDao) {
        this.baseDao = iAnswerDao;
        this.iAnswerDao = (IAnswerDao) iAnswerDao;
    }
}
