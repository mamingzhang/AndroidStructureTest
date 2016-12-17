package com.example.mamingzhang.androidstructuretest.data.manager.basicrealm;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by horsege on 2016/12/17.
 * <p>
 * 返回Realm实例
 */

public class BasicRealm {

    private static final RealmConfiguration basicRealmCofiguration;

    static {
        basicRealmCofiguration = new RealmConfiguration.Builder()
                .name("basicrealm.realm").build();
    }

    public static Realm getBasicRealm() {
        return Realm.getInstance(basicRealmCofiguration);
    }
}
