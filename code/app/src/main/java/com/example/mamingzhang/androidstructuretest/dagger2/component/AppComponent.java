package com.example.mamingzhang.androidstructuretest.dagger2.component;

import android.content.Context;

import com.example.mamingzhang.androidstructuretest.dagger2.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mamingzhang on 16/12/16.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context applicationContext();
}
