package com.ssmbook2020.service;

import com.ssmbook2020.entity.User;

/**
 * 用户的业务接口
 */
public interface UserService {
	/**
	 * 登录的方法
	 * @param name 用户名
	 * @param password 密码
	 * @return 登录成功返回User对象，登录失败返回null
	 */
	public User login(String name,String password);
}
