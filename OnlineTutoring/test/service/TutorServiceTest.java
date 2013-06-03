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

import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.ITutorService;

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
    
	User user = new User("person@user.com", "pw123456", 's');
 
    @Test
    public void testCreate() {
        
        int beforeDbCount = tutorService.countAll();
        
        tutorService.save(genRandomTutor());
        
        int afterDbCount = tutorService.countAll();
        
        assertEquals(beforeDbCount + 1, afterDbCount);
    }
    
    @Test
    public void testUpdate() {
        
        Tutor tutor = tutorService.save(genRandomTutor());
        int expectedGrade = 2;
        tutor.setBalance(expectedGrade);
        tutorService.update(tutor);
        
        int actualGrade = tutorService.get(tutor.getId()).getBalance();
        
        assertEquals(expectedGrade, actualGrade);
        
    }
    
    @Test
    public void testDelete() {

        int beforeDbCount = tutorService.countAll();
        
        Tutor tutor = tutorService.save(genRandomTutor());
        
        tutorService.delete(tutor.getId());
        
        int afterDbCount = tutorService.countAll();
        
        assertEquals(beforeDbCount, afterDbCount);
    }
    
    @Test
    public void testList() {	

    	Tutor tutor = tutorService.save(genRandomTutor());
        
        List<Tutor> tutorList = tutorService.listAll();
        
        assertThat(tutorList, hasItem(tutor));
    }
    
    
    public Tutor genRandomTutor() {
        Tutor tutor = new Tutor(user);
        user.setTutor(tutor);
        return tutor;
    }
}
