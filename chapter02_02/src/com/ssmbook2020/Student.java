package com.ssmbook2020;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * ѧ����
 */
@Component("student") //������ŵ�������ȥ
public class Student {
	
	@Value("${student.id}")
	private Integer id;  //���
	
	@Autowired
	@Qualifier("woman")
	private String name;  //����
	
	@Value("${student.sex}")
	private Boolean sex;  //�Ա���true��Ůfalse
	
	@Value("2021/02/25")
	private Date birthday;  //����
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + "]";
	}

}
