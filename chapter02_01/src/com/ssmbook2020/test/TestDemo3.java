package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.Car;

/**
 * Scope�ĵ����Ͷ�������
 */
public class TestDemo3 {

	public static void main(String[] args) {
		// ����Spring������Ĭ�ϴ���·���¶�ȡapplicationContext.xml�����ļ�
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// �������л�ȡ��������
		Car c1 = (Car) context.getBean("benZ");
		Car c2 = (Car) context.getBean("benZ");
		System.out.println("��1������:" + c1);
		System.out.println("��2������:" + c2);
		System.out.println(c1 == c2);
		// �ر�����
		context.close();
	}

}
