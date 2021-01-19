package com.ssmbook2020;

/**
 * 奔驰实现类
 */
public class BenZ implements Car {

	@Override
	public void drive() {
		System.out.println("开奔驰车");
	}

	public BenZ() {
		System.out.println("构造方法");
	}

	// 初始化的方法
	public void init() {
		System.out.println("初始化的方法");
	}

	// 销毁的方法
	public void destroy() {
		System.out.println("销毁的方法");
	}
}
