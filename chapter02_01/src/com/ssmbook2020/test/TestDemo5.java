package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.Customer;

public class TestDemo5 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//�������л�ȡ����
		Customer customer = (Customer) context.getBean("customer");
		System.out.println(customer);
		//�ر�����
		context.close();
	}

}
