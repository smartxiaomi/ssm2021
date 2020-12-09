package com.ssmbook2020.test;

import com.ssmbook2020.entity.Employee;
import com.ssmbook2020.entity.PageBean;
import com.ssmbook2020.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //指定Spring的运行器
@ContextConfiguration("classpath:applicationContext.xml")  //指定Spring的配置文件
public class TestEmployee {

    @Autowired  //注入业务对象
    private EmployeeService employeeService;

    @Test
    public void testFindPage() {
        //创建查询条件
        HashMap<String, Object> param = new HashMap<>();
        //查询第1页
        param.put("current", 1);
        //每页显示3条
        param.put("size", 3);
        //模糊查询姓名
        param.put("name", "刘");
        //调用业务方法
        PageBean<Employee> pageBean = employeeService.findPageBean(param);
        System.out.println(pageBean);
    }
}
