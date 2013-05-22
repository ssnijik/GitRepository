/**
 * 
 */
package com.onlinetutoring.dao.impl;

import org.springframework.stereotype.Repository;

import com.onlinetutoring.dao.ITutorDao;
import com.onlinetutoring.domain.Tutor;

/**
 * @author Ssn
 *
 */
@Repository("tutorDao")
public class TutorDao extends BaseDao<Tutor, Integer>  implements ITutorDao{

}
