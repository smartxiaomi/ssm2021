package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.Car;

/**
 * Scope�ĵ����Ͷ�������
 */
public class TestDemo4 {

	public static void main(String[] args) {
		// ����Spring������Ĭ�ϴ���·���¶�ȡapplicationContext.xml�����ļ�
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//�������л�ȡ����
		Car benZ = (Car) context.getBean("benZ");
		//�ر�����
		context.close();
	}

}
