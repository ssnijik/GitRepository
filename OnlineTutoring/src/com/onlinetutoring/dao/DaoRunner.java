/**
 * Dao Test
 */
package com.onlinetutoring.dao;

import java.util.Date;

import com.onlinetutoring.pojo.*;

/**
 * @author Ssn
 *
 */
public class DaoRunner {
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrangementDao arrangementDao  = new ArrangementDao();
		CourseDao courseDao = new CourseDao();
		MasterDao masterDao = new MasterDao();
		NotificationDao notificationDao = new NotificationDao();
		PersonDao personDao = new PersonDao();
		PostingDao postingDao = new PostingDao();
		StudentDao studentDao = new StudentDao();
		StudentTimetableDao studentTimetableDao = new StudentTimetableDao();
		SubjectDao subjectDao = new SubjectDao();
		TimetableDao timetableDao = new TimetableDao();
		TutorDao tutorDao = new TutorDao();
		
		
		Arrangement arrangement;
		Course course;
		Master master;
		Notification notification;
		Person person;
		Posting posting;
		Student student;
		StudentTimetable studentTimetable;
		Subject subject;
		Timetable timetable;
		Tutor tutor;
		
		
		person = new Person("fn1", "ln1", "e1@mail.com", "pw123456a");
		Person recipient = new Person("fn2", "ln2", "e2@mail.com", "pw123456b");
		student = new Student(recipient);
		tutor = new Tutor(person);
		subject = new Subject();
		course = new Course(subject, "course1", 2);
		arrangement = new Arrangement(tutor, course);
		timetable = new Timetable(arrangement);
		studentTimetable = new StudentTimetable(student, timetable);
		
		notification = new Notification(person, recipient, "i come");
		master = new Master(person, "title1", "content1");
		posting = new Posting(person, "ptitle1", "pcontent1", master);
		
		
		personDao.addPerson(person);
		personDao.addPerson(recipient);
		
		studentDao.addStudent(student);
		tutorDao.addTutor(tutor);
		subjectDao.addSubject(subject);
		courseDao.addCourse(course);
		arrangementDao.addArrangement(arrangement);
		timetableDao.addTimetable(timetable);
		studentTimetableDao.addStudentTimetable(studentTimetable);
		
		notificationDao.addNotification(notification);
		masterDao.addMaster(master);
		postingDao.addPosting(posting);

	}
	
	

}
