package com.ssmbook2020.test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ssmbook2020.Student;

public class TestStudent1 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = context.getBean(Student.class);
		System.out.println(student);
		// ¹Ø±ÕÈÝÆ÷
		context.close();
	}
}
