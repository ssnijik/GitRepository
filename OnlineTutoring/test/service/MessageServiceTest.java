/**
 * 
 */
package service;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    

    User sender = new User("send@er.com", "pw123456", 's');
    User receiver = new User("receive@er.com", "pw654321", 't');
 
    @Test
    public void testCreate() {
        
        int beforeDbCount = messageService.countAll();
        
        messageService.save(genRandomMessage());
        
        int afterDbCount = messageService.countAll();
        
        assertEquals(beforeDbCount + 1, afterDbCount);
    }
    
    @Test
    public void testUpdate() {
        
        Message message = messageService.save(genRandomMessage());
        String expectedContent = "math";
        message.setContent(expectedContent);
        messageService.update(message);
        
        String actualContent = messageService.get(message.getId()).getContent();
        
        assertEquals(expectedContent, actualContent);
        
    }
    
    @Test
    public void testDelete() {

        int beforeDbCount = messageService.countAll();
        
        Message message = messageService.save(genRandomMessage());
        
        User us = message.getSender();
        
        User ur = message.getReceiver();
        
        us.getSends().remove(message);
        
        ur.getReceives().remove(message);
        
//        message.setSender(null);
//        
//        message.setReceiver(null);
        
        messageService.delete(message.getId());
        
        int afterDbCount = messageService.countAll();
        
        assertEquals(beforeDbCount, afterDbCount);
    }
    
    @Test
    public void testList() {

    	Message message = messageService.save(genRandomMessage());
        
        List<Message> messageList = messageService.listAll();
        
        assertThat(messageList, hasItem(message));
    }
    
    
    public Message genRandomMessage() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Message message = new Message();
        message.setContent("ni" + randomKey);
        message.setSender(sender);
        message.setReceiver(receiver);
        sender.setSends(new HashSet<Message>());
        receiver.setReceives(new HashSet<Message>());
        
        sender.getSends().add(message);
        receiver.getReceives().add(message);

        return message;
    }
}
