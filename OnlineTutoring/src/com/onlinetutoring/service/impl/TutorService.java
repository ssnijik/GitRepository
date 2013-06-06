/**
 * 
 */
package com.onlinetutoring.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlinetutoring.dao.IBaseDao;
import com.onlinetutoring.dao.ISubjectDao;
import com.onlinetutoring.dao.ITutorDao;
import com.onlinetutoring.dao.IUserDao;
import com.onlinetutoring.domain.Course;
import com.onlinetutoring.domain.Subject;
import com.onlinetutoring.domain.Tutor;
import com.onlinetutoring.domain.User;
import com.onlinetutoring.service.ITutorService;

/**
 * @author Ssn
 * 
 */
@Service("tutorService")
public class TutorService extends BaseService<Tutor, Integer> implements
		ITutorService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TutorService.class);
	private ITutorDao tutorDao;

	@Autowired
	@Qualifier("subjectDao")
	private ISubjectDao subjectDao;

	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	@Autowired
	@Qualifier("tutorDao")
	@Override
	public void setBaseDao(IBaseDao<Tutor, Integer> tutorDao) {
		this.baseDao = tutorDao;
		this.tutorDao = (ITutorDao) tutorDao;
	}

	@Override
	public List<Tutor> getTutors() {
		return tutorDao.listAll();
	}

	@Override
	public int getTutorPageCount(int pageSize) {
		int countAll = tutorDao.countAll();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}

	@Override
	public List<Tutor> getTutors(int pageNumber, int pageSize) {
		return tutorDao.listAll(pageNumber, pageSize);
	}

	@Override
	public List<Tutor> getTutorsBySubject(String subjectName) {
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);

		return new ArrayList<Tutor>(subject.getTutors());
	}

	@Override
	public int getTutorPageCountBySubjectPageCount(String subjectName,
			int pageSize) {
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);

		int countAll = subject.getTutors().size();
		int countPage = countAll / pageSize;
		return countAll % pageSize == 0 ? countPage : countPage + 1;
	}

	@Override
	public List<Tutor> getTutorsBySubject(String subjectName, int pageNumber,
			int pageSize) {

		List<Tutor> tutorList = tutorDao.listAllWithHql(pageNumber, pageSize,
				"select t from Tutor t join t.subjects s where s.name = '"
						+ subjectName + "' order by t.id desc");
		return tutorList;
	}

	@Override
	public void addSpecialty(String email, String subjectName) {
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();

		tutor.getSubjects().add(subject);
		subject.getTutors().add(tutor);

		// tutorDao.update(tutor);
		// subjectDao.update(subject);

	}

	// TODO test
	@Override
	public void addSpecialties(String email, List<Integer> subjectids) {

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();

		Subject subject;

		Iterator<Integer> iterator = subjectids.iterator();

		while (iterator.hasNext()) {
			subject = subjectDao.get((Integer) iterator.next());
			tutor.getSubjects().add(subject);
			subject.getTutors().add(tutor);
			// subjectDao.update(subject);
		}

		// tutorDao.update(tutor);

	}

	@Override
	public void delSpecialty(String email, String subjectName) {
		Subject querySubject = new Subject();
		querySubject.setName(subjectName);
		Subject subject = subjectDao.queryByCriteriaUnique(querySubject);

		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();

		tutor.getSubjects().remove(subject);
		subject.getTutors().remove(tutor);

		tutorDao.update(tutor);
		subjectDao.update(subject);
	}

	@Override
	public List<Course> getCourses(String email) {
		User queryUser = new User();
		queryUser.setEmail(email);
		User user = userDao.queryByCriteriaUnique(queryUser);
		Tutor tutor = user.getTutor();

		return new ArrayList<Course>(tutor.getCourses());
	}

}
