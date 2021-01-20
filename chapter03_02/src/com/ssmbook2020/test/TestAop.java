package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.service.AccountService;

public class TestAop {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器中获取对象
		AccountService accountService = context.getBean(AccountService.class);
		//得到的是代理对象
		System.out.println(accountService.getClass());
		//调用业务方法
		accountService.save();
		// 关闭容器
		context.close();
	}

}
