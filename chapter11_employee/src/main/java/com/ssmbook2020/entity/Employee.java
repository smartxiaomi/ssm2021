package com.ssmbook2020.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
//日期使用sql的Date对象
import java.sql.Date;
@Data
public class Employee {
    private Integer id;
    private String name;
    private String sex;
    private Double salary;
    //用于指定日期格式化，要指定时区，不然日期少一天
    @JsonFormat(pattern = "yyyy年MM月dd日", timezone = "GMT+8")
    private Date birthday;
    private Integer departId;
    private Depart depart;
    //年龄字段在数据库中没有，通过生日计算出来的
    private Integer age;
}
