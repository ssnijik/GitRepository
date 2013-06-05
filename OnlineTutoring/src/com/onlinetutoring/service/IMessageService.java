/**
 * 
 */
package com.onlinetutoring.service;

import java.util.List;

import com.onlinetutoring.domain.Message;

/**
 * @author Ssn
 *
 */
public interface IMessageService extends IBaseService<Message, Integer> {

	boolean addMessage(String senderEmail, String receiverEmail, String content);

	List<Message> getMessageToMe(String receiverEmail);

	List<Message> getMessageFromMe(String senderEmail);

	void deleteMessage(int messageid);

	List<Message> getMessage(String senderEmail, String receiverEmail);

	List<Message> getMessageBypage(String senderEmail, String receiverEmail,
			int pageNumber, int pageSize);

}
