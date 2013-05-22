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

import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.service.ISubjectService;

/**
 * @author Ssn
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class SubjectServiceTest {

AtomicInteger counter = new AtomicInteger();
    
	@Autowired
	@Qualifier("subjectService")
    private ISubjectService subjectService;
    

 
    @Test
    public void testCreate() {
        
        int beforeDbCount = subjectService.countAll();
        
        subjectService.save(genRandomSubject());
        
        int afterDbCount = subjectService.countAll();
        
        assertEquals(beforeDbCount + 1, afterDbCount);
    }
    
    @Test
    public void testUpdate() {
        
        Subject subject = subjectService.save(genRandomSubject());
        String expectedName = "math";
        subject.setName(expectedName);
        subjectService.update(subject);
        
        String actualName = subjectService.get(subject.getId()).getName();
        
        assertEquals(expectedName, actualName);
        
    }
    
    @Test
    public void testDelete() {

        int beforeDbCount = subjectService.countAll();
        
        Subject subject = subjectService.save(genRandomSubject());
        
        subjectService.delete(subject.getId());
        
        int afterDbCount = subjectService.countAll();
        
        assertEquals(beforeDbCount, afterDbCount);
    }
    
    @Test
    public void testList() {

    	Subject subject = subjectService.save(genRandomSubject());
        
        List<Subject> subjectList = subjectService.listAll();
        
        assertThat(subjectList, hasItem(subject));
    }
    
    
    public Subject genRandomSubject() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Subject subject = new Subject();
        subject.setName("ni" + randomKey);

        return subject;
    }
}
