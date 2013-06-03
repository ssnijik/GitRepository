/**
 * 
 */
package service;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IUserService;

/**
 * @author Ssn
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class UserServiceTest {

AtomicInteger counter = new AtomicInteger();
    
	@Autowired
	@Qualifier("userService")
    private IUserService userService;
    

 
    @Test
    public void testCreate() {
        
        int beforeDbCount = userService.countAll();
        
        userService.save(genRandomUser());
        
        int afterDbCount = userService.countAll();
        
        assertEquals(beforeDbCount + 1, afterDbCount);
    }
    
    @Test
    public void testUpdate() {
        
        User user = userService.save(genRandomUser());
        String expectedPassword = "123234";
        user.setPassword(expectedPassword);
        userService.update(user);
        
        String actualPassword = userService.get(user.getId()).getPassword();
        
        assertEquals(expectedPassword, actualPassword);
        
    }
    
    @Test
    public void testDelete() {

        int beforeDbCount = userService.countAll();
        
        User user = userService.save(genRandomUser());
        
        userService.delete(user.getId());
        
        int afterDbCount = userService.countAll();
        
        assertEquals(beforeDbCount, afterDbCount);
    }
    
    @Test
    public void testList() {

    	User user = userService.save(genRandomUser());
        
        List<User> userList = userService.listAll();
        
        assertThat(userList, hasItem(user));
    }
    
    @Test
    public void testGetUser() {
        
        User u = userService.save(genRandomUser());
        
        boolean b = userService.isUserExist("zhang@sishuok.com");
        
        System.out.println(userService.isUserExist("zhang@sishuok.com"));

        assertEquals(b, true);
    }
    
    
    public User genRandomUser() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        User user = new User();
        user.setFirstName("ni" + randomKey);
        user.setLastName("mei" + randomKey);
        user.setEmail("zhang@sishuok.com");
        user.setPassword("123456");
//        user.setType('s');
        return user;
    }
}
