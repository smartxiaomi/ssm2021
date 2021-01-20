package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.service.UserService;

public class TestAop {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//得到业务类
		UserService userService = (UserService) context.getBean("userService");
		//运行业务登录方法
		userService.login("newboy", "520");
		//userService.login("Lina", "1314");
		context.close();
	}

}
