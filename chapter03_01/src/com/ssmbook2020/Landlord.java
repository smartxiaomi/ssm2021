package com.ssmbook2020;

/**
 * ��������ʵ��ɫ
 */
public class Landlord implements Lease {

	@Override
	public void rentOut(int money) {
		System.out.println("�������ⷿ�ӣ�����ǣ�" + money);
	}
}
