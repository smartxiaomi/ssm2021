package com.ssmbook2020.entity;

/**
 * 用户实体类对象
 */
public class User {
	private int id; // 主键
	private String name; // 用户名
	private String password; // 密码

	public User(int id, String name, String password) { // 带全参的构造方法
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User() { // 默认无参构造方法
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
