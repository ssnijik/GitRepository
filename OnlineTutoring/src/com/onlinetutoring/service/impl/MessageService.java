/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.IMessageDao;
import com.onlinetutoring.dao.INotificationDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Message;
import com.onlinetutoring.domain.Notification;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IMessageService;

/**
 * @author Ssn
 * 
 */
@Service("messageService")
public class MessageService extends BaseService<Message, Integer> implements
		IMessageService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MessageService.class);
	private IMessageDao messageDao;

	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;
	
	@Autowired
	@Qualifier("notificationDao")
	private INotificationDao notificationDao;

	@Autowired
	@Qualifier("messageDao")
	@Override
	public void setBaseDao(IBaseDao<Message, Integer> messageDao) {
		this.baseDao = messageDao;
		this.messageDao = (IMessageDao) messageDao;
	}
	@Override
	public boolean addMessage(String senderEmail, String receiverEmail,
			String content) {
		User querySender = new User();
		querySender.setEmail(senderEmail);
		User sender = userDao.queryByCriteriaUnique(querySender);

		User queryReceiver = new User();
		queryReceiver.setEmail(receiverEmail);
		User receiver = userDao.queryByCriteriaUnique(queryReceiver);
		
		Message message = new Message(sender, receiver, content);
		if(messageDao.save(message) != null){
			Notification queryNotification = new Notification();
			queryNotification.setType('m');
			queryNotification.setUser(receiver);
			if(notificationDao.queryByCriteriaUnique(queryNotification) == null){
				notificationDao.save(new Notification(message.getId(), 'm', receiver));
			}
			return true;
		}
		return false;

	}
	@Override
	public List<Message> getMessageToMe(String receiverEmail) {

		User queryReceiver = new User();
		queryReceiver.setEmail(receiverEmail);
		User receiver = userDao.queryByCriteriaUnique(queryReceiver);
		
		return new ArrayList<Message>(receiver.getReceives());
	}
	@Override
	public List<Message> getMessageFromMe(String senderEmail) {

		User querySender = new User();
		querySender.setEmail(senderEmail);
		User sender = userDao.queryByCriteriaUnique(querySender);
		
		return new ArrayList<Message>(sender.getReceives());
	}
	@Override
	public void deleteMessage(int messageid) {
		messageDao.delete(messageid);
	}
	@Override
	public List<Message> getMessage(String senderEmail, String receiverEmail) {
		User querySender = new User();
		querySender.setEmail(senderEmail);
		User sender = userDao.queryByCriteriaUnique(querySender);

		User queryReceiver = new User();
		queryReceiver.setEmail(receiverEmail);
		User receiver = userDao.queryByCriteriaUnique(queryReceiver);
		
		List<Message> messageList = messageDao.listAll("( model.sender.id = "
				+ sender.getId() + " and model.receiver.id=" + receiver.getId()
				+ " and isRead = false ) or (model.sender.id=" + receiver.getId()
				+ " and model.receiver.id = " + sender.getId() + " and isRead = false )");

		messageDao.update("set isRead = true where ( model.sender.id="
				+ sender.getId() + " and model.receiver.id=" + receiver.getId()
				+ ") or (model.sender.id=" + receiver.getId()
				+ " and model.receiver.id=" + sender.getId() + ")");
		
		if(messageList.size() < 3){
			messageList = messageDao.listAll(1, 3, "( model.sender.id = "
					+ sender.getId() + " and model.receiver.id=" + receiver.getId()
					+ " ) or (model.sender.id=" + receiver.getId()
					+ " and model.receiver.id = " + sender.getId() + " )");
		}
		
		return messageList;

	}
	@Override
	public List<Message> getMessageBypage(String senderEmail,
			String receiverEmail, int pageNumber, int pageSize) {
		User querySender = new User();
		querySender.setEmail(senderEmail);
		User sender = userDao.queryByCriteriaUnique(querySender);

		User queryReceiver = new User();
		queryReceiver.setEmail(receiverEmail);
		User receiver = userDao.queryByCriteriaUnique(queryReceiver);

		return messageDao.listAll(pageNumber, pageSize, "( model.sender.id=" + sender.getId()
				+ " and model.receiver.id=" + receiver.getId()
				+ " ) or ( model.sender.id=" + receiver.getId()
				+ " and model.receiver.id=" + sender.getId() + " )");
	}
}
