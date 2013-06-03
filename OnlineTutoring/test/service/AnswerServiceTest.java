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

import com.onlinetutoring.domain.Answer;
import com.onlinetutoring.domain.Question;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IAnswerService;
import com.onlinetutoring.service.IQuestionService;
import com.onlinetutoring.service.ISubjectService;
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
		@Qualifier("questionService")
		private IQuestionService questionService;
		
		@Autowired
		@Qualifier("answerService")
		private IAnswerService answerService;
		
		@Autowired
		@Qualifier("userService")
		private IUserService userService;
		
		@Autowired
		@Qualifier("subjectService")
		private ISubjectService subjectService;
	
 
//    @Test
//    public void testCreate() {
//        
//        int beforeDbCount = answerService.countAll();
//        
//        answerService.save(genRandomAnswer());
//        
//        int afterDbCount = answerService.countAll();
//        
//        assertEquals(beforeDbCount + 1, afterDbCount);
//    }
//    
//    @Test
//    public void testUpdate() {
//        
//        Answer answer = answerService.save(genRandomAnswer());
//        String expectedContent = "math";
//        answer.setContent(expectedContent);
//        answerService.update(answer);
//        
//        String actualContent = answerService.get(answer.getId()).getContent();
//        
//        assertEquals(expectedContent, actualContent);
//        
//    }
//    
//    @Test
//    public void testDelete() {
//
//        int beforeDbCount = answerService.countAll();
//        
//        Answer answer = answerService.save(genRandomAnswer());
//        
//        User u = answer.getUser();
//        
//        Question q = u.getQuestions().iterator().next();
//        
//        q.getAnswers().remove(answer);
//        
//        answerService.delete(answer.getId());
//        
//        int afterDbCount = answerService.countAll();
//        
//        assertEquals(beforeDbCount, afterDbCount);
//    }
//    
//    @Test
//    public void testList() {
//
//    	Answer answer = answerService.save(genRandomAnswer());
//        
//        List<Answer> answerList = answerService.listAll();
//        
//        assertThat(answerList, hasItem(answer));
//    }
    
	@Test
    public void testAddAnswer() {

    	int beforeDbCount = answerService.countAll();
    	
        User user1 = genRandomUser();
        
        Question question = genRandomQuestion();
        
        Subject subject = genRandomSubject();
        
        Answer answer = genRandomAnswer();

        User user2 = genRandomUser();
        
        question.setUser(user1);
        question.setSubject(subject);
        question.setAnswers(new HashSet<Answer>());
        question.getAnswers().add(answer);
        answer.setQuestion(question);
        answer.setUser(user2);
        
        User user3 = genRandomUser();
    	
        questionService.save(question);  
        userService.save(user3);
        
        
        answerService.addAnswer(user3.getEmail(), "bilibili", question.getId(), null);
        
        int afterDbCount = answerService.countAll();
        
        assertEquals(beforeDbCount + 2, afterDbCount);
        
    }
	
	@Test
    public void testgetAnswers() {
		User user1 = genRandomUser();
        
        Question question = genRandomQuestion();
        
        Subject subject = genRandomSubject();
        
        Answer answer = genRandomAnswer();

        User user2 = genRandomUser();
        user2.setAnswers(new HashSet<Answer>());
        user2.getAnswers().add(answer);
        
        question.setUser(user1);
        question.setSubject(subject);
        question.setAnswers(new HashSet<Answer>());
        question.getAnswers().add(answer);
        answer.setQuestion(question);
        answer.setUser(user2);
    	
        questionService.save(question);  
        List<Answer> answerList = answerService.getAnswers(user2.getEmail());
        
        assertThat(answerList, hasItem(answer));
        
    }
	
	@Test
    public void testgetAnswerById() {
		User user1 = genRandomUser();
        
        Question question = genRandomQuestion();
        
        Subject subject = genRandomSubject();
        
        Answer answer = genRandomAnswer();

        User user2 = genRandomUser();
        
        question.setUser(user1);
        question.setSubject(subject);
        question.setAnswers(new HashSet<Answer>());
        question.getAnswers().add(answer);
        answer.setQuestion(question);
        answer.setUser(user2);
    	
        questionService.save(question);
        assertEquals(answerService.getAnswerById(answer.getId()), answer);
        

        
    }
	
	@Test
    public void testgetAnswersquestionid() {

User user1 = genRandomUser();
        
        Question question = genRandomQuestion();
        
        Subject subject = genRandomSubject();
        
        Answer answer = genRandomAnswer();

        User user2 = genRandomUser();
        user2.setAnswers(new HashSet<Answer>());
        user2.getAnswers().add(answer);
        
        question.setUser(user1);
        question.setSubject(subject);
        question.setAnswers(new HashSet<Answer>());
        question.getAnswers().add(answer);
        answer.setQuestion(question);
        answer.setUser(user2);
    	
        questionService.save(question);  
        List<Answer> answerList = answerService.getAnswers(question.getId());
        
        assertThat(answerList, hasItem(answer));

        
    }
	
//	@Test
//    public void testgetMyAnswerPageCount() {
//
//
//        
//    }
	
//	@Test
//    public void testgetMyAnswersByPage() {
//
//
//        
//    }
	
//	@Test
//    public void testdeleteAnswer() {
//
//
//        
//    }
	
	
	
    public Subject genRandomSubject() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Subject subject = new Subject();
        subject.setName("ni" + randomKey);

        return subject;
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
    
    public Question genRandomQuestion() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Question question = new Question();
        question.setTitle("title" + randomKey);
        question.setContent("content"+ randomKey);
        
        return question;
    }

    
    public Answer genRandomAnswer() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Answer answer = new Answer();
        answer.setContent("content"+randomKey);

        return answer;
    }
}
