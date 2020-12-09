package com.ssmbook2020.dao;
import com.ssmbook2020.entity.Depart;
import org.apache.ibatis.annotations.*;
import java.util.List;
/**
 * 部门的DAO类
 */
public interface DepartDao {
    /**
     * 查询所有部门
     */
    @Select("select * from depart")
    List<Depart> findAllDeparts();
}
