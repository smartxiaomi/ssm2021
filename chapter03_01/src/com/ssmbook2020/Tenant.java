package com.ssmbook2020;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 租客：使用代理对象的调用者
 */
public class Tenant {

	public static void main(String[] args) {
		// 1.直接找房东租房(创建真实对象)
		Lease landlord = new Landlord();
		//调用真实对象的方法
		landlord.rentOut(2000);
		System.out.println("真实对象：" + landlord.getClass());
		//分隔开
		System.out.println("==========");
		// 2.找中介租房 (创建代理对象)
		Lease agent = (Lease) Proxy.newProxyInstance(landlord.getClass().getClassLoader(), // 真实对象的类加载器
				landlord.getClass().getInterfaces(), // 获取真实对象所有实现的接口
				new InvocationHandler() { // 代理的实现
					/**
					 * proxy：即方法newProxyInstance()方法返回的代理对象 
					 * method: 真实对象的方法对象，每次调用method对象都不同
					 * args：代理对象调用方法时传递的参数
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// 如果是出租的方法
						if (method.getName().equals("rentOut")) {
							//对真实方法进行代理，但不修改原来类的方法
							System.out.println("中介出租房子，收取中介费：200");
						}
						//调用真实对象的方法
						return method.invoke(landlord, args);
					}
				});
		//调用代理对象的方法
		agent.rentOut(2000);
		//输出代理对象
		System.out.println("代理对象：" + agent.getClass());
	}

}
