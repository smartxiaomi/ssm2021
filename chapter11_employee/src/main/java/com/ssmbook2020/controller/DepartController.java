package com.ssmbook2020.controller;

import com.ssmbook2020.entity.Depart;
import com.ssmbook2020.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

    /**
     * 查询所有部门
     */
    @RequestMapping("/findAll")
    @ResponseBody  //返回格式化好的JSON字符串
    public List<Depart> findAllDeparts() {
        return departService.findAllDeparts();
    }

}
