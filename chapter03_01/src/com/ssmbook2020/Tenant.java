package com.ssmbook2020;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ��ͣ�ʹ�ô������ĵ�����
 */
public class Tenant {

	public static void main(String[] args) {
		// 1.ֱ���ҷ����ⷿ(������ʵ����)
		Lease landlord = new Landlord();
		//������ʵ����ķ���
		landlord.rentOut(2000);
		System.out.println("��ʵ����" + landlord.getClass());
		//�ָ���
		System.out.println("==========");
		// 2.���н��ⷿ (�����������)
		Lease agent = (Lease) Proxy.newProxyInstance(landlord.getClass().getClassLoader(), // ��ʵ������������
				landlord.getClass().getInterfaces(), // ��ȡ��ʵ��������ʵ�ֵĽӿ�
				new InvocationHandler() { // �����ʵ��
					/**
					 * proxy��������newProxyInstance()�������صĴ������ 
					 * method: ��ʵ����ķ�������ÿ�ε���method���󶼲�ͬ
					 * args�����������÷���ʱ���ݵĲ���
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// ����ǳ���ķ���
						if (method.getName().equals("rentOut")) {
							//����ʵ�������д��������޸�ԭ����ķ���
							System.out.println("�н���ⷿ�ӣ���ȡ�н�ѣ�200");
						}
						//������ʵ����ķ���
						return method.invoke(landlord, args);
					}
				});
		//���ô������ķ���
		agent.rentOut(2000);
		//����������
		System.out.println("�������" + agent.getClass());
	}

}
