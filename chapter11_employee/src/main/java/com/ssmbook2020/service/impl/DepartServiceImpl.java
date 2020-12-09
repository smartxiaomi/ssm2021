package com.ssmbook2020.service.impl;

import com.ssmbook2020.dao.DepartDao;
import com.ssmbook2020.entity.Depart;
import com.ssmbook2020.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartDao departDao;
    /**
     * 查询所有部门
     */
    @Override
    public List<Depart> findAllDeparts() {
        return departDao.findAllDeparts();
    }
}
