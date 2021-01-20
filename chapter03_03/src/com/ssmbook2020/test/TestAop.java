package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.service.UserService;

public class TestAop {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//�õ�ҵ����
		UserService userService = (UserService) context.getBean("userService");
		//����ҵ���¼����
		userService.login("newboy", "520");
		//userService.login("Lina", "1314");
		context.close();
	}

}
