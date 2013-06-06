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
	/**
	 * 添加消息
	 * 
	 * @param senderEmail
	 * @param receiverEmail
	 * @param content
	 * @return
	 */
	boolean addMessage(String senderEmail, String receiverEmail, String content);

	/**
	 * 返回发送给本人的消息
	 * 
	 * @param receiverEmail
	 * @return
	 */
	List<Message> getMessageToMe(String receiverEmail);

	/**
	 * 返回本人发出的消息
	 * 
	 * @param senderEmail
	 * @return
	 */
	List<Message> getMessageFromMe(String senderEmail);

	/**
	 * 根据消息id删除消息
	 * 
	 * @param messageid
	 */
	void deleteMessage(int messageid);

	/**
	 * 根据发送者email和接收者email获取未读的消息，如果未读消息小于3条则获取最近的3条消息
	 * 
	 * @param senderEmail
	 * @param receiverEmail
	 * @return
	 */
	List<Message> getMessage(String senderEmail, String receiverEmail);

	/**
	 * 根据发送者email和接收者email获取消息分页页数
	 * @param senderEmail
	 * @param receiverEmail
	 * @param pageSize
	 * @return
	 */
	int getMessagePageCount(String senderEmail, String receiverEmail,
			int pageSize);

	/**
	 * 根据发送者email和接收者email分页获取最近的消息
	 * @param senderEmail
	 * @param receiverEmail
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<Message> getMessageByPage(String senderEmail, String receiverEmail,
			int pageNumber, int pageSize);

}
