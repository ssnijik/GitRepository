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

import com.onlinetutoring.domain.Student;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.IStudentService;

/**
 * @author Ssn
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class StudentServiceTest {

AtomicInteger counter = new AtomicInteger();
    
	@Autowired
	@Qualifier("studentService")
    private IStudentService studentService;
    
	User user = new User("person@user.com", "pw123456", 's');
 
    @Test
    public void testCreate() {
        
        int beforeDbCount = studentService.countAll();
        
        studentService.save(genRandomStudent());
        
        int afterDbCount = studentService.countAll();
        
        assertEquals(beforeDbCount + 1, afterDbCount);
    }
    
    @Test
    public void testUpdate() {
        
        Student student = studentService.save(genRandomStudent());
        int expectedGrade = 2;
        student.setGrade(expectedGrade);
        studentService.update(student);
        
        int actualGrade = studentService.get(student.getId()).getGrade();
        
        assertEquals(expectedGrade, actualGrade);
        
    }
    
    @Test
    public void testDelete() {

        int beforeDbCount = studentService.countAll();
        
        Student student = studentService.save(genRandomStudent());
        
        studentService.delete(student.getId());
        
        int afterDbCount = studentService.countAll();
        
        assertEquals(beforeDbCount, afterDbCount);
    }
    
    @Test
    public void testList() {

    	Student student = studentService.save(genRandomStudent());
        
        List<Student> studentList = studentService.listAll();
        
        assertThat(studentList, hasItem(student));
    }
    
    
    public Student genRandomStudent() {
        Student student = new Student(user);
        user.setStudent(student);
        return student;
    }
}
