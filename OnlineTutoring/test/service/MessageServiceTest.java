/**
 * 
 */
package service;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.onlinetutoring.domain.Message;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IMessageService;
import com.onlinetutoring.service.IUserService;

/**
 * @author Ssn
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class MessageServiceTest {

AtomicInteger counter = new AtomicInteger();
    
	@Autowired
	@Qualifier("messageService")
	private IMessageService messageService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
    

//    @Test
//    public void testCreate() {
//        
//        int beforeDbCount = messageService.countAll();
//        
//        messageService.save(genRandomMessage());
//        
//        int afterDbCount = messageService.countAll();
//        
//        assertEquals(beforeDbCount + 1, afterDbCount);
//    }
//    
//    @Test
//    public void testUpdate() {
//        
//        Message message = messageService.save(genRandomMessage());
//        String expectedContent = "math";
//        message.setContent(expectedContent);
//        messageService.update(message);
//        
//        String actualContent = messageService.get(message.getId()).getContent();
//        
//        assertEquals(expectedContent, actualContent);
//        
//    }
//    
//    @Test
//    public void testDelete() {
//
//        int beforeDbCount = messageService.countAll();
//        
//        Message message = messageService.save(genRandomMessage());
//        
//        User us = message.getSender();
//        
//        User ur = message.getReceiver();
//        
//        us.getSends().remove(message);
//        
//        ur.getReceives().remove(message);
//        
////        message.setSender(null);
////        
////        message.setReceiver(null);
//        
//        messageService.delete(message.getId());
//        
//        int afterDbCount = messageService.countAll();
//        
//        assertEquals(beforeDbCount, afterDbCount);
//    }
//    
//    @Test
//    public void testList() {
//
//    	Message message = messageService.save(genRandomMessage());
//        
//        List<Message> messageList = messageService.listAll();
//        
//        assertThat(messageList, hasItem(message));
//    }
    
    @Test
    public void testgetMessage(){
    	User user1 = genRandomUser();
    	user1.setSends(new HashSet<Message>());
    	user1.setReceives(new HashSet<Message>());
        User user2 = genRandomUser();
        user2.setSends(new HashSet<Message>());
    	user2.setReceives(new HashSet<Message>());
        
        Message message = genRandomMessage();
        
        message.setSender(user1);
        user1.getSends().add(message);
        message.setReceiver(user2);
        user2.getReceives().add(message);
        
        messageService.save(message);
        
        List<Message> messageList = messageService.getMessage(user1.getEmail(), user2.getEmail());
        
        assertThat(messageList, hasItem(message));
        
        
    }
	
	public Message genRandomMessage(){
		long randomKey = System.nanoTime() + counter.addAndGet(1);
		Message message = new Message();
		message.setContent("content" + randomKey);
		return message;
	}
    
    
    public User genRandomUser() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        User user = new User();
        user.setFirstName("ni" + randomKey);
        user.setLastName("mei" + randomKey);
        user.setEmail("ni@mei.com" + randomKey);
        user.setPassword("123456");
        user.setType('s');
        return user;
    }
}
