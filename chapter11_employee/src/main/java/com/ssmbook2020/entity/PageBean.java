package com.ssmbook2020.entity;

import lombok.Data;

import java.util.List;

/**
 * 分页对象
 */
@Data
public class PageBean<T>  {
    /*
    一共是8个属性，分成三大类：
    1. 从数据库中查询出来的属性：data, count
    2. 由用户从浏览器提交过来：current, size
    3. 由其它的属性计算出来的：first, previous,next,total，写在get方法中
     */
    private List<T> data;  //封装1页的数据
    private int count;   //总记录数
    private int current;  //当前第几页
    private int size;  //每页的大小
    private int first; //第一页
    private int previous; //上一页
    private int next; //下一页
    private int total; //总页数/最后一页
    //构造方法传入四个属性
    public PageBean(List<T> data, int count, int current, int size) {
        this.data = data;
        this.count = count;
        this.current = current;
        this.size = size;
    }

    public PageBean() {
    }

    /**
     * 获取第1页
     * @return
     */
    public int getFirst() {
        return 1;
    }
    /**
     * 获取上一页
     * 如果当前页大于1，上一页就等于当前页减一
     * 否则返回第1页
     */
    public int getPrevious() {
        if (getCurrent() > 1) {
            return getCurrent() - 1;
        } else {
            return 1;
        }
    }
    /**
     * 计算下一页
     * 如果当前页小于最后一页，下一页就等于当前页加一
     * 否则返回最后一页
     */
    public int getNext() {
        if (getCurrent() < getTotal()) {
            return getCurrent() + 1;
        } else {
            return getTotal();
        }
    }
    /**
     * 计算总页数
     * 如果总记录数能够整除页大小，就正好是这么多页
     * 如果不能整除，页数就加一
     */
    public int getTotal() {
        if (getCount() % getSize() == 0) {
            return getCount() / getSize();
        } else {
            return getCount() / getSize() + 1;
        }
    }
    //注：输出的是get方法的值，才是准确的
    @Override
    public String toString() {
        return "PageBean{" +
                "data=" + getData() +
                ", count=" + getCount() +
                ", current=" + getCurrent() +
                ", size=" + getSize() +
                ", first=" + getFirst() +
                ", previous=" + getPrevious() +
                ", next=" + getNext() +
                ", total=" + getTotal() +
                '}';
    }
}
