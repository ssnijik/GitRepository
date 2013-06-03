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
public class QuestionServiceTest {

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
//        int beforeDbCount = questionService.countAll();
//        
//        int beforeDbCount1 = userService.countAll();
//        
//        User user1 = genRandomUser();
//        
//        Question question = genRandomQuestion();
//        
//        Subject subject = genRandomSubject();
//        
//        Answer answer = genRandomAnswer();
//
//        User user2 = genRandomUser();
//        
//        question.setUser(user1);
//        question.setSubject(subject);
//        question.setAnswers(new HashSet<Answer>());
//        question.getAnswers().add(answer);
//        answer.setQuestion(question);
//        answer.setUser(user2);
//    	
//        questionService.save(question);
//
//        
//        int afterDbCount = questionService.countAll();
//        
//        int afterDbCount1 = userService.countAll();
//        
//        System.out.println(userService.isUserExist(user1.getEmail()));
//    	System.out.println(userService.isUserExist(user2.getEmail()));
//        
//        assertEquals(beforeDbCount + 1, afterDbCount);
//        
//        assertEquals(beforeDbCount1 + 2, afterDbCount1);
//    }
//    
//    @Test
//    public void testUpdate() {
//        
//        Question question = questionService.save(genRandomQuestion());
//        String expectedContent = "math";
//        question.setContent(expectedContent);
//        questionService.update(question);
//        
//        String actualContent = questionService.get(question.getId()).getContent();
//        
//        assertEquals(expectedContent, actualContent);
//        
//    }
//    
//    @Test
//    public void testDelete() {
//
//        int beforeDbCount = questionService.countAll();
//        
//        Question question = questionService.save(genRandomQuestion());
//        
//        User u = question.getUser();
//        
//        u.getQuestions().remove(question);
//        
//        Subject s = question.getSubject();
//        
//        s.getQuestions().remove(question);
//        
//        questionService.delete(question.getId());
//        
//        int afterDbCount = questionService.countAll();
//        
//        assertEquals(beforeDbCount, afterDbCount);
//    }
//    
//    @Test
//    public void testList() {
//
//    	Question question = questionService.save(genRandomQuestion());
//        
//        List<Question> questionList = questionService.listAll();
//        
//        assertThat(questionList, hasItem(question));
//    }
    
    @Test
    public void testSaveAnswer() {

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
        
        
        questionService.addAnswer(user3.getEmail(), "bilibili", question.getId(), null);
        
        int afterDbCount = answerService.countAll();
        
        assertEquals(beforeDbCount + 2, afterDbCount);
        
    }
    
    @Test
    public void testAddQuestion() {

    	int beforeDbCount = questionService.countAll();
    	
        User user = genRandomUser();

        Subject subject = genRandomSubject();
        
        userService.save(user);
        subjectService.save(subject);
        
        questionService.addQuestion(user.getEmail(), "title1", "content1", subject.getName(), null, null, null);
        
        int afterDbCount = questionService.countAll();
        
        assertEquals(beforeDbCount + 1, afterDbCount);
        
    }
    
    @Test
    public void testGetQuestionByID(){
    	Question question = genRandomQuestion();
    	User user = genRandomUser();
    	Subject subject = genRandomSubject();
    	
    	question.setUser(user);
    	question.setSubject(subject);
    	
    	questionService.save(question);
    	Question q = questionService.getQuestionById(question.getId());
    	assertEquals(user.getId(), q.getUser().getId());
    }
    
    @Test
    public void testgetQuestions(){
    	Question question = genRandomQuestion();
    	User user = genRandomUser();
    	Subject subject = genRandomSubject();
    	
    	user.setQuestions(new HashSet<Question>(){});
    	user.getQuestions().add(question);
    	
    	question.setUser(user);
    	question.setSubject(subject);
    	
    	questionService.save(question);
    	List<Question> questionList = questionService.getQuestions(user.getEmail());
    	assertThat(questionList, hasItem(question));
    }
    
    
    @Test
    public void testgetAnswers(){

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
        
        List<Answer> answerList = questionService.getAnswers(question.getId());
        
        assertThat(answerList, hasItem(answer));
    }
    
//    @Test
//    public void testgetMyQuestions(){
//    	
//    }
    
//    @Test
//    public void testgetRealFileName(){
//    	
//    }
    
    @Test
    public void testgetQuestionPageCount(){
    	Question question = genRandomQuestion();
    	User user = genRandomUser();
    	Subject subject = genRandomSubject();
    	
    	user.setQuestions(new HashSet<Question>(){});
    	user.getQuestions().add(question);
    	
    	question.setUser(user);
    	question.setSubject(subject);
    	
    	questionService.save(question);
    	int countPage = questionService.getQuestionPageCount(5);
    	assertEquals(1, countPage);
    }
    
    @Test
    public void testgetQuestionsByPage(){
    	Question question = genRandomQuestion();
    	User user = genRandomUser();
    	Subject subject = genRandomSubject();
    	
    	user.setQuestions(new HashSet<Question>(){});
    	user.getQuestions().add(question);
    	
    	question.setUser(user);
    	question.setSubject(subject);
    	
    	questionService.save(question);
    	List<Question> questionList = questionService.getQuestionsByPage(1, 5);
    	assertThat(questionList, hasItem(question));
    	
    }
    
//    @Test
//    public void testgetMyQuestionPageCount(){
//    	
//    }
//    
//    @Test
//    public void testgetMyQuestionspp(){
//    	
//    }
    
    @Test
    public void testgetCommentPageCount(){
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
        int countPage = questionService.getCommentPageCount(5, question.getId());
        assertEquals(1, countPage);
    }
    
    @Test
    public void testgetCommentsByPage(){
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
        List<Answer> answerList = questionService.getCommentsByPage(1, 5, question.getId());
    	assertThat(answerList, hasItem(answer));
    }
    
//    @Test
//    public void testdeleteTopic(){
//    	
//    }
    
    @Test
    public void testincreaseView(){
    	
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
    
    public Subject genRandomSubject() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Subject subject = new Subject();
        subject.setName("ni" + randomKey);

        return subject;
    }
    
    public Answer genRandomAnswer() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Answer answer = new Answer();
        answer.setContent("content"+randomKey);

        return answer;
    }
}
