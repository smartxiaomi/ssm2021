package com.ssmbook2020.service.impl;

import com.ssmbook2020.entity.User;
import com.ssmbook2020.service.UserService;

/**
 * �û�ҵ�����ʵ��
*/
public class UserServiceImpl implements UserService {
	
	@Override
	public User login(String name, String password) {
		System.out.println("ҵ�񷽷�login���У����ڵ�¼...");
		//��¼�ɹ�
		if ("newboy".equals(name) && "520".equals(password)) {
			return new User(100, "newboy", "520");
		}
		//��¼ʧ��
		return null;
	}
}