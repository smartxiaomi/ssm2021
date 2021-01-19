package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.Car;

/**
 * Scope的单例和多例对象
 */
public class TestDemo3 {

	public static void main(String[] args) {
		// 创建Spring容器，默认从类路径下读取applicationContext.xml配置文件
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中获取汽车对象
		Car c1 = (Car) context.getBean("benZ");
		Car c2 = (Car) context.getBean("benZ");
		System.out.println("第1个对象:" + c1);
		System.out.println("第2个对象:" + c2);
		System.out.println(c1 == c2);
		// 关闭容器
		context.close();
	}

}
