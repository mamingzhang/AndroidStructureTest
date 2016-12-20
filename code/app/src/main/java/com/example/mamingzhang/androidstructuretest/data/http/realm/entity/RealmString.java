package com.example.mamingzhang.androidstructuretest.data.http.realm.entity;

import io.realm.RealmObject;

/**
 * Created by mamingzhang on 16/12/19.
 */

public class RealmString extends RealmObject {
    private String val;

    public RealmString() {

    }

    public RealmString(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
