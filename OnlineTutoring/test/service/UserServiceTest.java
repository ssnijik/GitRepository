/**
 * 
 */
package service;

import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.onlinetutoring.domain.Student;
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
    

 
//    @Test
//    public void testCreate() {
//        
//        int beforeDbCount = userService.countAll();
//        
//        userService.save(genRandomUser());
//        
//        int afterDbCount = userService.countAll();
//        
//        assertEquals(beforeDbCount + 1, afterDbCount);
//    }
    
//    @Test
//    public void testUpdate() {
//        
//        User user = userService.save(genRandomUser());
//        String expectedPassword = "123234";
//        user.setPassword(expectedPassword);
//        userService.update(user);
//        
//        String actualPassword = userService.get(user.getId()).getPassword();
//        
//        assertEquals(expectedPassword, actualPassword);
//        
//    }
//    
//    @Test
//    public void testDelete() {
//
//        int beforeDbCount = userService.countAll();
//        
//        User user = userService.save(genRandomUser());
//        
//        userService.delete(user.getId());
//        
//        int afterDbCount = userService.countAll();
//        
//        assertEquals(beforeDbCount, afterDbCount);
//    }
//    
//    @Test
//    public void testList() {
//
//    	User user = userService.save(genRandomUser());
//        
//        List<User> userList = userService.listAll();
//        
//        assertThat(userList, hasItem(user));
//    }
//    
//    @Test
//    public void testGetUser() {
//        
//        User u = userService.save(genRandomUser());
//        
//        boolean b = userService.isUserExist("zhang@sishuok.com");
//        
//        System.out.println(userService.isUserExist("zhang@sishuok.com"));
//
//        assertEquals(b, true);
//    }
    
    @Test
    public void testaddFriend(){
    	User user1 = genRandomUser();
    	User user2 = genRandomUser();
    	
    	Student student1 = genRandomStudent();
    	Student student2 = genRandomStudent();
    	
    	user1.setStudent(student1);
    	student1.setUser(user1);
    	user2.setStudent(student2);
    	student2.setUser(user2);
    	
    	user1.setFriendsHaveMe(new HashSet<User>());
        user1.setFriendsIHave(new HashSet<User>());
    	
        user2.setFriendsHaveMe(new HashSet<User>());
        user2.setFriendsIHave(new HashSet<User>());
    	
    	userService.save(user1);
    	
    	userService.save(user2);
    	
    	System.out.println(user1);
    	System.out.println(user2);
    	
    	userService.addFriend(user1.getEmail(), user2.getId());
    	User u = userService.get(user1.getId());
    	assertThat(u.getFriendsHaveMe(), hasItem(user2));
    }
    
    
    public User genRandomUser() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        User user = new User();
        user.setFirstName("ni" + randomKey);
        user.setLastName("mei" + randomKey);
        user.setEmail("zhang@sishuok.com" + randomKey);
        user.setPassword("123456");
        
        user.setType('s');
//        user.setPoint(0);
        return user;
    }
    
    public Student genRandomStudent() {
        Student student = new Student();
        return student;
    }
}
