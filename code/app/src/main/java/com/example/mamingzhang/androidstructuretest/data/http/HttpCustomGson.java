package com.example.mamingzhang.androidstructuretest.data.http;

import com.example.mamingzhang.androidstructuretest.data.http.realm.GsonRealmCastListDeserializer;
import com.example.mamingzhang.androidstructuretest.data.http.realm.GsonRealmStringListTypeAdapter;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by mamingzhang on 16/12/19.
 *
 * 生成自定义的Gson解析器
 */

public class HttpCustomGson {
    private static final Gson customGson;
    static {
        customGson = new GsonBuilder()
                //过滤器，暂时不过滤任何类型
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return false;
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                //注册RealmList<RealmString>解析器
                .registerTypeAdapter(GsonRealmStringListTypeAdapter.getType(), new GsonRealmStringListTypeAdapter())
                //注册RealmList<MovieRealmCast>解析器
                .registerTypeAdapter(GsonRealmCastListDeserializer.getType(), new GsonRealmCastListDeserializer())
                .create();
    }

    public static Gson createGson() {
        return customGson;
    }
}
