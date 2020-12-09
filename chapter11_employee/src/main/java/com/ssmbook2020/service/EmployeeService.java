package com.ssmbook2020.service;

import com.ssmbook2020.entity.Employee;
import com.ssmbook2020.entity.PageBean;
import java.util.Map;

public interface EmployeeService {

    /**
     * 查询一页数据，封装成一个页面对象
     * @param param 查询条件
     */
    PageBean<Employee> findPageBean(Map<String, Object> param);

    /**
     * 添加员工
     */
    int save(Employee employee);

    /**
     * 更新员工
     */
    int update(Employee employee);

    /**
     * 删除员工
     */
    int delete(Integer id);

    /**
     * 删除多个员工
     */
    int deleteEmployees(Integer[] employeeIds);
}
