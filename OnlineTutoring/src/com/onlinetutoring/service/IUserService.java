/**
 * 
 */
package com.onlinetutoring.service;

import java.util.Date;
import java.util.List;

import com.onlinetutoring.domain.User;

/**
 * @author Ssn
 * 
 */
public interface IUserService extends IBaseService<User, Integer> {

	/**
	 * 登录
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean login(String email, String password);

	/**
	 * 判断actioncontext里是否有email变量
	 * @return
	 */
	public boolean canLoginBySession();

	/**
	 * 不知道，问潘岩
	 * @return
	 */
	public boolean canLoginByCookie();

	/**
	 * 添加一个用户，函数原名register
	 * @param password
	 * @param email
	 * @param type
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	public boolean addUser(String password, String email, String type,
			String firstname, String lastname);

	/**
	 * 判断用户（email）是否存在
	 * @param email
	 * @return
	 */
	public boolean isUserExist(String email);

	/**
	 * 更新一个用户资料
	 * @param password
	 * @param email
	 * @param firstname
	 * @param lastname
	 * @param phone
	 * @param birthday
	 * @param cardNumber
	 * @param picture
	 * @param school
	 */
	void updateUser(String password, String email, String firstname,
			String lastname, String phone, Date birthday, String cardNumber,
			String picture, String school);

	/**
	 * 根据本人email和好友id添加好友
	 * @param email
	 * @param userid
	 */
	void addFriend(String email, int userid);

	/**
	 * 根据本人email和好友id删除好友
	 * @param email
	 * @param userid
	 */
	void delFriend(String email, int userid);

	/**
	 * 根据本人email获取我的好友
	 * @param email
	 * @return
	 */
	List<User> getFriends(String email);

	/**
	 * 根据本人email和好友id添加好友申请通知
	 * @param email
	 * @param userid
	 */
	void addFriendApplication(String email, int userid);
}
