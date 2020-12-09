package com.ssmbook2020.service;
import com.ssmbook2020.entity.Depart;
import java.util.List;
/**
 * 部门的业务层
 */
public interface DepartService {
    /**
     * 查询所有部门
     */
    List<Depart> findAllDeparts();
}
