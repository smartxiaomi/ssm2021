package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.Car;

/**
 * 从Spring容器中获取对象
 */
public class TestDemo2 {
	
	public static void main(String[] args) {
		//创建Spring容器，默认从类路径下读取applicationContext.xml配置文件
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器中获取汽车对象
		Car benZ = (Car) context.getBean("benZ");
		//调用汽车类的方法
		benZ.drive();
		//关闭容器
		context.close();
	}

}
