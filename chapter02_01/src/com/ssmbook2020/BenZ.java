package com.ssmbook2020;

/**
 * ����ʵ����
 */
public class BenZ implements Car {

	@Override
	public void drive() {
		System.out.println("�����۳�");
	}

	public BenZ() {
		System.out.println("���췽��");
	}

	// ��ʼ���ķ���
	public void init() {
		System.out.println("��ʼ���ķ���");
	}

	// ���ٵķ���
	public void destroy() {
		System.out.println("���ٵķ���");
	}
}
