package com.example.mamingzhang.androidstructuretest.data.http;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * Created by horsege on 2016/12/17.
 *
 * 提供用于Retrofit请求所需要的OkHttpClient
 */

public class HttpOkHttpClient {
    private Context context;

    public HttpOkHttpClient(Context context) {
        this.context = context;
    }

    public OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.networkInterceptors().add(new StethoInterceptor());
        okHttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS);

        return okHttpClientBuilder.build();
    }
}
