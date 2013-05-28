package com.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.test.spring.UserBiz;

public class TestSpring {
	public static void main(String[] args)
	{
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		UserBiz userBiz = (UserBiz)context.getBean("userBiz");
		if(userBiz.login("admin", "134"))
		{
			System.out.println("ok");
		}
		else
		{
			System.out.println("false");
		}
	}
}
