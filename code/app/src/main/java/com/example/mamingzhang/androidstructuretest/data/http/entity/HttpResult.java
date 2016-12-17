package com.example.mamingzhang.androidstructuretest.data.http.entity;

/**
 * Created by horsege on 2016/12/17.
 * <p>
 * 纯粹为了演示，参考豆瓣电影Api返回做的封装，实际上需要根据接口规则来定义
 * <p>
 * 比如一般的接口都是有resultCode和resultData字段，根据resultCode返回是否成功才需要解析具体的数据Data
 */

public class HttpResult<T> {
    //以下字段相当于resultCode字段
    private int count;
    private int start;
    private int total;
    private String title;

    //以下字段相当于具体的Data字段
    private T subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }
}
