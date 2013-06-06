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

import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.ITutorService;
import com.onlinetutoring.service.IUserService;

/**
 * @author Ssn
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TutorServiceTest {

AtomicInteger counter = new AtomicInteger();
    
	@Autowired
	@Qualifier("tutorService")
    private ITutorService tutorService;

 
	@Autowired
	@Qualifier("userService")
    private IUserService userService;
	
	
//    @Test
//    public void testCreate() {
//        
//        int beforeDbCount = tutorService.countAll();
//        
//        tutorService.save(genRandomTutor());
//        
//        int afterDbCount = tutorService.countAll();
//        
//        assertEquals(beforeDbCount + 1, afterDbCount);
//    }
//    
//    @Test
//    public void testUpdate() {
//        
//        Tutor tutor = tutorService.save(genRandomTutor());
//        int expectedGrade = 2;
//        tutor.setBalance(expectedGrade);
//        tutorService.update(tutor);
//        
//        int actualGrade = tutorService.get(tutor.getId()).getBalance();
//        
//        assertEquals(expectedGrade, actualGrade);
//        
//    }
//    
//    @Test
//    public void testDelete() {
//
//        int beforeDbCount = tutorService.countAll();
//        
//        Tutor tutor = tutorService.save(genRandomTutor());
//        
//        tutorService.delete(tutor.getId());
//        
//        int afterDbCount = tutorService.countAll();
//        
//        assertEquals(beforeDbCount, afterDbCount);
//    }
//    
//    @Test
//    public void testList() {	
//
//    	Tutor tutor = tutorService.save(genRandomTutor());
//        
//        List<Tutor> tutorList = tutorService.listAll();
//        
//        assertThat(tutorList, hasItem(tutor));
//    }
	
	@Test
	public void testgetTutorsBySubject(){
		User user = genRandomUser();
		
		Tutor tutor = genRandomTutor();
		
		Subject subject = genRandomSubject();
		
		user.setTutor(tutor);
		tutor.setUser(user);
		subject.getTutors().add(tutor);
		tutor.getSubjects().add(subject);
		
		userService.save(user);
		
		List<Tutor> tutorList = tutorService.getTutorsBySubject(subject.getName(), 1, 5);
		
		assertThat(tutorList, hasItem(tutor));
		
	}
    
    
    public Tutor genRandomTutor() {
        Tutor tutor = new Tutor();
        tutor.setSubjects(new HashSet<Subject>());
        return tutor;
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
    
    public Subject genRandomSubject() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Subject subject = new Subject();
        subject.setName("ni" + randomKey);
        subject.setTutors(new HashSet<Tutor>());

        return subject;
    }
}
