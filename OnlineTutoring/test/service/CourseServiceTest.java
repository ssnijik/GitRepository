/**
 * 
 */
package service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Student;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.ICourseService;
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
public class CourseServiceTest {

AtomicInteger counter = new AtomicInteger();
    
	@Autowired
	@Qualifier("courseService")
    private ICourseService courseService;
    
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("tutorService")
	private ITutorService tutorService;
	
	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;
 
//    @Test
//    public void testCreate() {
//        
//        int beforeDbCount = courseService.countAll();
//        
//        courseService.save(genRandomCourse());
//        
//        int afterDbCount = courseService.countAll();
//        
//        assertEquals(beforeDbCount + 1, afterDbCount);
//    }
//    
//    @Test
//    public void testUpdate() {
//        
//        Course course = courseService.save(genRandomCourse());
//        int expectedDuration = 3;
//        course.setDuration(expectedDuration);
//        courseService.update(course);
//        
//        int actualDuration = courseService.get(course.getId()).getDuration();
//        
//        assertEquals(expectedDuration, actualDuration);
//        
//    }
//    
//    @Test
//    public void testDelete() {
//
//        int beforeDbCount = courseService.countAll();
//        
//        Course course = courseService.save(genRandomCourse());
//        
//        courseService.delete(course.getId());
//        
//        int afterDbCount = courseService.countAll();
//        
//        assertEquals(beforeDbCount, afterDbCount);
//    }
//    
//    @Test
//    public void testList() {	
//
//    	Course course = courseService.save(genRandomCourse());
//        
//        List<Course> courseList = courseService.listAll();
//        
//        assertThat(courseList, hasItem(course));
//    }
    
    
    @Test
    public void testaddApplication() {
        
        User user1 = genRandomUser();
        
        Subject subject = genRandomSubject();

        User user2 = genRandomUser();
        
        Student student = genRandomStudent();
        
        student.setUser(user1);
        user1.setStudent(student);
        
        Tutor tutor = genRandomTutor();
        
        tutor.setUser(user2);
        user2.setTutor(tutor);
        
        Course course = genRandomCourse();
        
        course.setSubject(subject);
        
        course.setTutor(tutor);
        tutor.setCourses(new HashSet<Course>());
        tutor.getCourses().add(course);
        
        course.setApplications(new HashSet<Student>());
        student.setApplications(new HashSet<Course>());
        
        course.getApplications().add(student);
        student.getApplications().add(course);
        
        userService.save(user1);
        userService.save(user2);
//        courseService.save(course);
        
        User user3 = genRandomUser();
        Student student1 = genRandomStudent();
        student1.setApplications(new HashSet<Course>());
        
        student1.setUser(user3);
        user3.setStudent(student1);
        
        userService.save(user3);
        
        courseService.addApplication(user3.getEmail(), course.getId());
        
        Course testCourse = courseService.get(course.getId());
        
        
        System.out.println(student);
        System.out.println(student1);
        Iterator<Student> it = testCourse.getApplications().iterator();
        while(it.hasNext())
        System.out.println(it.next());
        
        assertEquals(2, testCourse.getApplications().size());
    }
    
    
    public Course genRandomCourse() {
    	long randomKey = System.nanoTime() + counter.addAndGet(1);
        Course course = new Course();
        course.setStartTime(new Date());
        course.setEndTime(new Date());
        course.setDuration(0);
        course.setPrice(3);
        course.setName("math class" + randomKey);
        course.setDescription("class for math" + randomKey);
        
        return course;
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
    
    public Subject genRandomSubject() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Subject subject = new Subject();
        subject.setName("ni" + randomKey);

        return subject;
    }
    
    public Student genRandomStudent() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Student student = new Student();

        return student;
    }
    
    public Tutor genRandomTutor() {
        long randomKey = System.nanoTime() + counter.addAndGet(1);
        Tutor tutor = new Tutor();

        return tutor;
    }
}
