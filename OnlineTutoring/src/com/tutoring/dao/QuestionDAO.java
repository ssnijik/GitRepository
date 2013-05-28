package com.tutoring.dao;

import java.util.List;

import com.tutoring.entity.Question;
import com.tutoring.entity.Subject;
import com.tutoring.entity.User;

public interface QuestionDAO {
	public void addQuestion(User user, String title, String content, Subject subject,String pic_sn, String attach_sn,String attach_name);
	public Question getQuestionById(int id);
	public List<Question> getQuestionsByUser(User u);
	public String getFileNameBySN(String sn);
	public int getPageNumber();
	public void deleteQuestion(Question q);
}
