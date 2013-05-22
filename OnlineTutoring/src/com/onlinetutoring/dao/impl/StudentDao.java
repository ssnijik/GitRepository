/**
 * 
 */
package com.onlinetutoring.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlinetutoring.dao.IStudentDao;
import com.onlinetutoring.domain.Student;

/**
 * @author Ssn
 *
 */
@Repository("studentDao")
public class StudentDao extends BaseDao<Student, Integer> implements IStudentDao{

}
