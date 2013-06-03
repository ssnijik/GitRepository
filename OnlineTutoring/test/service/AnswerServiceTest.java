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

import com.onlinetutoring.domain.Answer;
import com.onlinetutoring.domain.Question;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IAnswerService;
import com.onlinetutoring.service.IUserService;


/**
 * @author Ssn
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class AnswerServiceTest {

AtomicInteger counter = new AtomicInteger();
    
	@Autowired
	@Qualifier("answerService")
	private IAnswerService answerService;
	

    User user = new User("person@user.com", "pw123456", 's');
    Subject subject = new Subject("math");
    Question question = new Question(user, "title1", "content1", subject);
 
    @Test
    public void testCreate() {
        
        int beforeDbCount = answerService.countAll();
        
        answerService.save(genRandomAnswer());
        
        int afterDbCount = answerService.countAll();
        
        assertEquals(beforeDbCount + 1, afterDbCount);
    }
    
    @Test
    public void testUpdate() {
        
        Answer answer = answerService.save(genRandomAnswer());
        String expectedContent = "math";
        answer.setContent(expectedContent);
        answerService.update(answer);
        
        String actualContent = answerService.get(answer.getId()).getContent();
        
        assertEquals(expectedContent, actualContent);
        
    }
    
    @Test
    public void testDelete() {

        int beforeDbCount = answerService.countAll();
        
        Answer answer = answerService.save(genRandomAnswer());
        
        User u = answer.getUser();
        
        Question q = u.getQuestions().iterator().next();
        
        q.getAnswers().remove(answer);
        
        answerService.delete(answer.getId());
        
        int afterDbCount = answerService.countAll();
        
        assertEquals(beforeDbCount, afterDbCount);
    }
    
    @Test
    public void testList() {

    	Answer answer = answerService.save(genRandomAnswer());
        
        List<Answer> answerList = answerService.listAll();
        
        assertThat(answerList, hasItem(answer));
    }
    
    
    public Answer genRandomAnswer() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Answer answer = new Answer(user, "content2" + randomKey, question);
        question.setAnswers(new HashSet<Answer>());
        user.setQuestions(new HashSet<Question>());
        subject.setQuestions(new HashSet<Question>());
        
        question.getAnswers().add(answer);
        user.getQuestions().add(question);
        subject.getQuestions().add(question);

        return answer;
    }
}
