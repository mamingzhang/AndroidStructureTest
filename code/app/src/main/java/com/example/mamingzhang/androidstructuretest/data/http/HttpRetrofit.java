package com.example.mamingzhang.androidstructuretest.data.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by horsege on 2016/12/17.
 * <p>
 * 用于构造不同的Retrofit，主要是基于不同的baseUrl考虑
 * <p>
 * 相关参考资料：
 * 1. 源码解析---http://www.jianshu.com/p/c1a3a881a144
 */

public class HttpRetrofit {
    private static final String API_BASE_URL = "https://api.douban.com/v2/movie/";
    /**
     * 模拟器的IP地址是：10.0.2.2
     * 真机测试的IP地址是：电脑的IP地址，但必须处于同一网络
     */
    private static final String API_BASE_URL_LOCAL = "http://10.0.2.2:8080/movie/";

    public HttpRetrofit() {

    }

    /**
     * 返回对应Api请求的Retrofit
     *
     * @return
     */
    public Retrofit getApiRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(CustomResponseConvertyFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * 返回对应Api请求的Retrofit，不过这个不会经过实际的Http，而是通过moco模拟服务端数据
     *
     * @return
     */
    public Retrofit getLocalApiRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL_LOCAL)
                .client(okHttpClient)
                .addConverterFactory(CustomResponseConvertyFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
