package com.ssmbook2020.utils;

import java.sql.Timestamp;

/**
 * ��¼��־���ܵ��ࣺ������ = �����(����)+֪ͨ(����)
 */
public class LogAspect {

    /**
     * ��¼��־
     */
    public void printLog() {
        System.out.println(new Timestamp(System.currentTimeMillis()) + " ��¼��־");
    }
}