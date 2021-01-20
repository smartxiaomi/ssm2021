package com.ssmbook2020;

/**
 * 房东：真实角色
 */
public class Landlord implements Lease {

	@Override
	public void rentOut(int money) {
		System.out.println("房东出租房子，租金是：" + money);
	}
}
