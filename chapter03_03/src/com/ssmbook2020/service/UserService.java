package com.ssmbook2020.service;

import com.ssmbook2020.entity.User;

/**
 * �û���ҵ��ӿ�
 */
public interface UserService {
	/**
	 * ��¼�ķ���
	 * @param name �û���
	 * @param password ����
	 * @return ��¼�ɹ�����User���󣬵�¼ʧ�ܷ���null
	 */
	public User login(String name,String password);
}
