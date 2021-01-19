package com.ssmbook2020;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 学生类
 */
@Component("student") //将对象放到容器中去
public class Student {
	
	@Value("${student.id}")
	private Integer id;  //编号
	
	@Autowired
	@Qualifier("woman")
	private String name;  //姓名
	
	@Value("${student.sex}")
	private Boolean sex;  //性别：男true，女false
	
	@Value("2021/02/25")
	private Date birthday;  //生日
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + "]";
	}

}
