/**
 * 
 */
package service;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Date;
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

import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.ICourseService;

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
    
	User user = new User("person@user.com", "pw123456", 's');
	Tutor tutor = new Tutor(user);
	Subject subject = new Subject("math");
 
    @Test
    public void testCreate() {
        
        int beforeDbCount = courseService.countAll();
        
        courseService.save(genRandomCourse());
        
        int afterDbCount = courseService.countAll();
        
        assertEquals(beforeDbCount + 1, afterDbCount);
    }
    
    @Test
    public void testUpdate() {
        
        Course course = courseService.save(genRandomCourse());
        int expectedDuration = 3;
        course.setDuration(expectedDuration);
        courseService.update(course);
        
        int actualDuration = courseService.get(course.getId()).getDuration();
        
        assertEquals(expectedDuration, actualDuration);
        
    }
    
    @Test
    public void testDelete() {

        int beforeDbCount = courseService.countAll();
        
        Course course = courseService.save(genRandomCourse());
        
        courseService.delete(course.getId());
        
        int afterDbCount = courseService.countAll();
        
        assertEquals(beforeDbCount, afterDbCount);
    }
    
    @Test
    public void testList() {	

    	Course course = courseService.save(genRandomCourse());
        
        List<Course> courseList = courseService.listAll();
        
        assertThat(courseList, hasItem(course));
    }
    
    
    public Course genRandomCourse() {
        user.setTutor(tutor);
        Course course = new Course(new Date(), new Date(), 2, tutor, 3, "math class", "class for math", subject, 1,1,1,1,1,1);
        return course;
    }
}
