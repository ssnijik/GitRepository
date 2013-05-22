/**
 * 
 */
package com.onlinetutoring.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlinetutoring.dao.IAnswerDao;
import com.onlinetutoring.domain.Answer;

/**
 * @author Ssn
 *
 */
@Repository("answerDao")
public class AnswerDao extends BaseDao<Answer, Integer> implements IAnswerDao{

}
