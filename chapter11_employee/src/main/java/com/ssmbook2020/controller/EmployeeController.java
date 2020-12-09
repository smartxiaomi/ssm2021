package com.ssmbook2020.controller;

import com.ssmbook2020.entity.Employee;
import com.ssmbook2020.entity.PageBean;
import com.ssmbook2020.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController  //相当于@Controller和@ResponseBody两个注解
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询一页数据
     * @param param 封装查询条件
     */
    @RequestMapping("/findPage")
    public PageBean<Employee> findPage(@RequestBody Map<String, Object> param) {
        System.out.println("查询条件：" + param);
        return employeeService.findPageBean(param);
    }

    /**
     * 添加员工
     */
    @RequestMapping("/save")
    public int save(@RequestBody Employee employee) {
        System.out.println("添加员工：" + employee);
        return employeeService.save(employee);
    }

    /**
     * 更新员工
     */
    @RequestMapping("/update")
    public int update(@RequestBody Employee employee) {
        System.out.println("更新员工：" + employee);
        return employeeService.update(employee);
    }

    /**
     * 删除员工
     */
    @RequestMapping("/delete")
    public int update(Integer id) {
        System.out.println("删除的员工ID：" + id);
        return employeeService.delete(id);
    }

    /**
     * 删除多个员工
     */
    @RequestMapping("/deleteEmployees")
    public int deleteEmployees(@RequestBody Integer[] employeeIds) {
        System.out.println("删除的员工编号：" + Arrays.toString(employeeIds));
        return employeeService.deleteEmployees(employeeIds);
    }
}
