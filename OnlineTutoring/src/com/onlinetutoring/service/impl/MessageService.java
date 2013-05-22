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
import com.onlinetutoring.dao.IMessageDao;
import com.onlinetutoring.dao.impl.MessageDao;
import com.onlinetutoring.domain.Message;
import com.onlinetutoring.service.IMessageService;

/**
 * @author Ssn
 *
 */
@Service("messageService")
public class MessageService extends BaseService<Message, Integer> implements IMessageService{

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);
	private IMessageDao iMessageDao;

    @Autowired
    @Qualifier("messageDao")
    @Override
    public void setBaseDao(IBaseDao<Message, Integer> iMessageDao) {
        this.baseDao = iMessageDao;
        this.iMessageDao = (IMessageDao) iMessageDao;
    }
}
