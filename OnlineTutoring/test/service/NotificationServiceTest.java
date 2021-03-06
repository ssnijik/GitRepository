/**
 * 
 */
package service;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

import com.onlinetutoring.domain.Notification;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.INotificationService;
import com.onlinetutoring.service.impl.UserService;


/**
 * @author Ssn
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class NotificationServiceTest {

AtomicInteger counter = new AtomicInteger();
    
	@Autowired
	@Qualifier("notificationService")
	private INotificationService notificationService;
    

 
//    @Test
//    public void testCreate() {
//        
//        int beforeDbCount = notificationService.countAll();
//        
//        notificationService.save(genRandomNotification());
//        
//        int afterDbCount = notificationService.countAll();
//        
//        assertEquals(beforeDbCount + 1, afterDbCount);
//    }
//    
//    @Test
//    public void testUpdate() {
//        
//        Notification notification = notificationService.save(genRandomNotification());
//        int expectedType = 2;
//        notification.setType(expectedType);
//        notificationService.update(notification);
//        
//        int actualType = notificationService.get(notification.getId()).getType();
//        
//        assertEquals(expectedType, actualType);
//        
//    }
//    
//    @Test
//    public void testDelete() {
//
//        int beforeDbCount = notificationService.countAll();
//        
//        Notification notification = notificationService.save(genRandomNotification());
//        
//        User u = notification.getUser();
//        
//        u.getNotifications().remove(notification);
//        
//        notificationService.delete(notification.getId());
//        
//        int afterDbCount = notificationService.countAll();
//        
//        assertEquals(beforeDbCount, afterDbCount);
//    }
//    
//    @Test
//    public void testList() {
//
//    	Notification notification = notificationService.save(genRandomNotification());
//        
//        List<Notification> notificationList = notificationService.listAll();
//        
//        assertThat(notificationList, hasItem(notification));
//    }
	
	@Test
	public void testdeleteNotification(){
		
		
		
		User user = genRandomUser();
		
		Notification notification = genRandomNotification();
		
		notification.setUser(user);
		user.setNotifications(new HashSet<Notification>());
		user.getNotifications().add(notification);
		
		int beforeDbCount = notificationService.countAll();
		
		notificationService.save(notification);
		
		int middleDbCount = notificationService.countAll();
		
		notificationService.deleteNotification(user.getEmail());
		
		int afterDbCount = notificationService.countAll();
		
		assertEquals(beforeDbCount + 1, middleDbCount);
		
		assertEquals(middleDbCount , afterDbCount + 1);
		
		Notification n = notificationService.get(notification.getId());
		
		assertEquals(null , n);
	}
    
    
    public Notification genRandomNotification() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Notification notification = new Notification();
        notification.setNotification_id((int) randomKey);
        notification.setType('z');

        return notification;
    }
    
    public User genRandomUser() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        User user = new User();
        user.setFirstName("ni" + randomKey);
        user.setLastName("mei" + randomKey);
        user.setEmail("ni@mei.com" + randomKey);
        user.setPassword("123456");
//        user.setType('s');
        return user;
    }
}
