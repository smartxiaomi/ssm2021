package com.ssmbook2020;

/**
 * 出租的接口
 */
public interface Lease {

	/**
	 * 定义出租的行为
	 * @param money 租金
	 */
	void rentOut(int money);
}
