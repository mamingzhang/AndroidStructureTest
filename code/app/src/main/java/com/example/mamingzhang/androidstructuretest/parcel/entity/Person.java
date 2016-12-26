package com.example.mamingzhang.androidstructuretest.parcel.entity;

import org.parceler.Parcel;

/**
 * Created by horsege on 2016/12/26.
 */
@Parcel(Parcel.Serialization.BEAN)
public class Person {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
