package com.ssmbook2020;

import java.util.Date;

/**
 * 客户对象
 */
public class Customer {

	private int id;  //编号
	private String name;  //姓名
	private boolean male;  //性别是否男
	private Date birthday;  //生日
	
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

	//无参构造方法
	public Customer() {
	}

	//全参构造方法
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
