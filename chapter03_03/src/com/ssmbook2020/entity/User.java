package com.ssmbook2020.entity;

/**
 * �û�ʵ�������
 */
public class User {
	private int id; // ����
	private String name; // �û���
	private String password; // ����

	public User(int id, String name, String password) { // ��ȫ�εĹ��췽��
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User() { // Ĭ���޲ι��췽��
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
