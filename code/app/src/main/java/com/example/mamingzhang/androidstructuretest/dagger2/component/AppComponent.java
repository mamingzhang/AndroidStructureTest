package com.example.mamingzhang.androidstructuretest.dagger2.component;

import android.content.Context;

import com.example.mamingzhang.androidstructuretest.dagger2.module.AppModule;
import com.example.mamingzhang.androidstructuretest.data.http.HttpRequestMethod;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mamingzhang on 16/12/16.
 * <p>
 * 全局AppComponent，管理在App的全局实例，保证在App生命周期内，对象只有一个
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context applicationContext();

    HttpRequestMethod httpRequestMethod();
}
