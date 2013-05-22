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
import com.onlinetutoring.dao.IQuestionDao;
import com.onlinetutoring.dao.impl.QuestionDao;
import com.onlinetutoring.domain.Question;
import com.onlinetutoring.service.IQuestionService;

/**
 * @author Ssn
 *
 */
@Service("questionService")
public class QuestionService extends BaseService<Question, Integer> implements IQuestionService{

	private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);
	private IQuestionDao iQuestionDao;

    @Autowired
    @Qualifier("questionDao")
    @Override
    public void setBaseDao(IBaseDao<Question, Integer> iQuestionDao) {
        this.baseDao = iQuestionDao;
        this.iQuestionDao = (IQuestionDao) iQuestionDao;
    }
}
