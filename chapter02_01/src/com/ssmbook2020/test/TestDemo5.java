package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.Customer;

public class TestDemo5 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器中获取对象
		Customer customer = (Customer) context.getBean("customer");
		System.out.println(customer);
		//关闭容器
		context.close();
	}

}
