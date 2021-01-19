package com.ssmbook2020;

import java.util.Date;

/**
 * �ͻ�����
 */
public class Customer {

	private int id;  //���
	private String name;  //����
	private boolean male;  //�Ա��Ƿ���
	private Date birthday;  //����
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	//�޲ι��췽��
	public Customer() {
	}

	//ȫ�ι��췽��
	public Customer(int id, String name, boolean male, Date birthday) {
		this.id = id;
		this.name = name;
		this.male = male;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", name='" + name + '\'' + ", male=" + male + ", birthday=" + birthday + '}';
	}
}
