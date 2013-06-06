/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.ISubjectDao;
import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Question;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.service.ISubjectService;

/**
 * @author Ssn
 *
 */
@Service("subjectService")
public class SubjectService extends BaseService<Subject, Integer> implements ISubjectService{

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectService.class);
	private ISubjectDao subjectDao;

    @Autowired
    @Qualifier("subjectDao")
    @Override
    public void setBaseDao(IBaseDao<Subject, Integer> subjectDao) {
        this.baseDao = subjectDao;
        this.subjectDao = (ISubjectDao) subjectDao;
    }
    @Override
    public boolean addSubject(String subjectName){
    	Subject subject = new Subject(subjectName);
    	subject.setCourses(new HashSet<Course>());
    	subject.setQuestions(new HashSet<Question>());
    	subject.setTutors(new HashSet<Tutor>());
    	return subjectDao.save(subject) != null;
    }
    @Override
    public void updateSubject(String subjectName){
    	Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);
		
		subject.setName(subjectName);
		subjectDao.update(subject);
    }
    @Override
    public void delSubject(String subjectName){
    	Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);
		
		subjectDao.delete(subject.getId());
    }
    @Override
    public List<Subject> getSubjects(){
    	return subjectDao.listAll();
    }
}
