/**
 * 
 */
package com.onlinetutoring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinetutoring.pojo.Person;
import com.onlinetutoring.service.UserService;

/**
 * @author Ssn
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public String login (HttpServletRequest request, Person person) {
		return "ok";
	}
}
