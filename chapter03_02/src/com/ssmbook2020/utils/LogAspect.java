package com.ssmbook2020.utils;

import java.sql.Timestamp;

/**
 * 记录日志功能的类：切面类 = 切入点(规则)+通知(方法)
 */
public class LogAspect {

    /**
     * 记录日志
     */
    public void printLog() {
        System.out.println(new Timestamp(System.currentTimeMillis()) + " 记录日志");
    }
}