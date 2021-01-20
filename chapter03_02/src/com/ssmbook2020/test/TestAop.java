package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.service.AccountService;

public class TestAop {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//�������л�ȡ����
		AccountService accountService = context.getBean(AccountService.class);
		//�õ����Ǵ������
		System.out.println(accountService.getClass());
		//����ҵ�񷽷�
		accountService.save();
		// �ر�����
		context.close();
	}

}
