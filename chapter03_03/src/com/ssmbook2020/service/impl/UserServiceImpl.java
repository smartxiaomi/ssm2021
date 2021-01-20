package com.ssmbook2020.service.impl;

import com.ssmbook2020.entity.User;
import com.ssmbook2020.service.UserService;

/**
 * 用户业务类的实现
*/
public class UserServiceImpl implements UserService {
	
	@Override
	public User login(String name, String password) {
		System.out.println("业务方法login运行，正在登录...");
		//登录成功
		if ("newboy".equals(name) && "520".equals(password)) {
			return new User(100, "newboy", "520");
		}
		//登录失败
		return null;
	}
}