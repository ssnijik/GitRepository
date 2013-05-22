/**
 * 
 */
package com.onlinetutoring.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlinetutoring.dao.ISubjectDao;
import com.onlinetutoring.domain.Subject;

/**
 * @author Ssn
 *
 */
@Repository("subjectDao")
public class SubjectDao extends BaseDao<Subject, Integer>  implements ISubjectDao{

}
