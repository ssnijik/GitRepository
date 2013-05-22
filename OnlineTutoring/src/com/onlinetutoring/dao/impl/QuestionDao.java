/**
 * 
 */
package com.onlinetutoring.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlinetutoring.dao.IQuestionDao;
import com.onlinetutoring.domain.Question;

/**
 * @author Ssn
 *
 */
@Repository("questionDao")
public class QuestionDao extends BaseDao<Question, Integer> implements IQuestionDao{

	
}
