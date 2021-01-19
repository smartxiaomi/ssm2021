package com.ssmbook2020.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmbook2020.Car;

/**
 * Scope的单例和多例对象
 */
public class TestDemo4 {

	public static void main(String[] args) {
		// 创建Spring容器，默认从类路径下读取applicationContext.xml配置文件
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器中获取对象
		Car benZ = (Car) context.getBean("benZ");
		//关闭容器
		context.close();
	}

}
