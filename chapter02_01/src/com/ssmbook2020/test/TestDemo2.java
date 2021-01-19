package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.Car;

/**
 * ��Spring�����л�ȡ����
 */
public class TestDemo2 {
	
	public static void main(String[] args) {
		//����Spring������Ĭ�ϴ���·���¶�ȡapplicationContext.xml�����ļ�
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//�������л�ȡ��������
		Car benZ = (Car) context.getBean("benZ");
		//����������ķ���
		benZ.drive();
		//�ر�����
		context.close();
	}

}
