package com.ssmbook2020.dao;

import com.ssmbook2020.entity.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * 员工的DAO类
 */
public interface EmployeeDao {

    /**
     * 查询1页员工和部门信息
     */
    List<Employee> findEmployees(@Param("param") Map<String, Object> param);

    /**
     * 查询总记录数
     */
    int findCount(@Param("param") Map<String, Object> param);

    /**
     * 插入员工
     */
    @Insert("INSERT INTO employee VALUES (NULL,#{name},#{sex},#{salary},#{birthday},#{departId})")
    int save(Employee employee);

    /**
     * 更新员工
     */
    @Update("UPDATE employee SET name = #{name},sex = #{sex},salary = #{salary},birthday = #{birthday},depart_id = #{departId} WHERE id = #{id}")
    int update(Employee employee);

    /**
     * 删除员工
     */
    @Delete("delete from employee where id=#{id}")
    int delete(Integer id);

    /**
     * 删除多个员工
     */
    int deleteEmployees(Integer[] employeeIds);
}
