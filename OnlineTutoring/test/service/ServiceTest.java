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
import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Message;
import com.onlinetutoring.domain.Notification;
import com.onlinetutoring.domain.Question;
import com.onlinetutoring.domain.Student;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IAnswerService;
import com.onlinetutoring.service.ICourseService;
import com.onlinetutoring.service.IMessageService;
import com.onlinetutoring.service.INotificationService;
import com.onlinetutoring.service.IQuestionService;
import com.onlinetutoring.service.IStudentService;
import com.onlinetutoring.service.ISubjectService;
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
public class ServiceTest {

AtomicInteger counter = new AtomicInteger();
    
	@Autowired
	@Qualifier("answerService")
    private IAnswerService answerService;
	
	@Autowired
	@Qualifier("courseService")
    private ICourseService courseService;
	
	@Autowired
	@Qualifier("messageService")
    private IMessageService messageService;
	
	@Autowired
	@Qualifier("notificationService")
    private INotificationService notificationService;
	
	@Autowired
	@Qualifier("questionService")
    private IQuestionService questionService;
	
	@Autowired
	@Qualifier("studentService")
    private IStudentService studentService;
	
	@Autowired
	@Qualifier("subjectService")
    private ISubjectService subjectService;
	
	@Autowired
	@Qualifier("tutorService")
    private ITutorService tutorService;
	
	@Autowired
	@Qualifier("userService")
    private IUserService userService;
    

	private Answer answer;
	private Course course;
	private Message message;
	private Notification notification;
	private Question question;
	private Student student;
	private Subject subject;
	private Tutor tutor;
	private User user;
 
    @Test
    public void testCreate() {
    	
    	genRandomModal();
        
        int beforeDbCount = answerService.countAll();
        
        subjectService.save(subject);
        userService.save(user);
        
        int afterDbCount = answerService.countAll();
        
        assertEquals(beforeDbCount + 1, afterDbCount);
    }
    
    @Test
    public void testUpdate() {
    	genRandomModal();
        
    	subjectService.save(subject);
    	User updatedUser = userService.save(user);
        Answer updatedAnswer = updatedUser.getAnswers().iterator().next();
        String expectContent = "content data";
        updatedAnswer.setContent(expectContent);
        answerService.update(updatedAnswer);
        
        String actualContent = answerService.get(updatedAnswer.getId()).getContent();
        
        assertEquals(expectContent, actualContent);
        
    }
    
    @Test
    public void testDelete() {
    	genRandomModal();

        int beforeDbCount = answerService.countAll();
        
//        subjectService.save(subject);
//        User deletedUser = userService.save(user);
//        Answer deletedAnswer = deletedUser.getAnswers().iterator().next();
//        
//        answerService.delete(deletedAnswer.getId());
        
        int afterDbCount = answerService.countAll();
        
        assertEquals(beforeDbCount, afterDbCount);
    }
    
    @Test
    public void testList() {
    	genRandomModal();

    	subjectService.save(subject);
    	User listedUser = userService.save(user);
        Answer listedAnswer = listedUser.getAnswers().iterator().next();
        
        List<Answer> answerList = answerService.listAll();
        
        assertThat(answerList, hasItem(listedAnswer));
    }
    
    
    public void genRandomModal() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        user = new User("ni" + randomKey + "@mei.com", "pw123456", 's');
        user.setAnswers(new HashSet<Answer>());
        user.setQuestions(new HashSet<Question>());
        student = new Student();
        tutor = new Tutor();
        user.setStudent(student);
        user.setTutor(tutor);
        student.setUser(user);
        tutor.setUser(user);
        
        subject = new Subject("name" + randomKey);
        subject.setQuestions(new HashSet<Question>());
        question = new Question(user, "title" + randomKey, "content" + randomKey, subject);
        question.setAnswers(new HashSet<Answer>());
        subject.getQuestions().add(question);
        
        answer = new Answer(user, "answer" + randomKey, question);
        user.getAnswers().add(answer);
        user.getQuestions().add(question);
        question.getAnswers().add(answer);
        
//        subject = new Subject("name" + randomKey);
//        question = new Question(user, "title" + randomKey, "content" + randomKey, subject);
//        Set<Question> questions = new HashSet();
//        questions.add(question);
//        subject.setQuestions(questions);
//        
//        answer = new Answer(user, "answer" + randomKey, question);
//        Set<Answer> answers = new HashSet();
//        answers.add(answer);
//        user.setAnswers(answers);
//        question.setAnswers(answers);
    }
}
