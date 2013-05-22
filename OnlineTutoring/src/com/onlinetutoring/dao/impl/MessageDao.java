/**
 * 
 */
package com.onlinetutoring.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlinetutoring.dao.IMessageDao;
import com.onlinetutoring.domain.Message;

/**
 * @author Ssn
 *
 */
@Repository("messageDao")
public class MessageDao extends BaseDao<Message, Integer> implements IMessageDao{

}
