package com.tutoring.dao;

import java.util.List;

public interface PageDAO {
	public List<?> findByPage(final String hql, final int offset, final int pageSize);
	public int getPageCount(String nameOfEntity, String whereClause);
	//public int getMyQuestionPageCount(final int userid);
	//public int getCommentPageCount
}
