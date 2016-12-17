package com.example.mamingzhang.androidstructuretest;

import android.app.Application;
import android.content.Context;

import com.example.mamingzhang.androidstructuretest.dagger2.AppComponentHolder;
import com.example.mamingzhang.androidstructuretest.dagger2.component.DaggerAppComponent;
import com.example.mamingzhang.androidstructuretest.dagger2.module.AppModule;
import com.facebook.stetho.Stetho;

/**
 * Created by mamingzhang on 16/12/16.
 */

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

        //初始化顶级Component也就是AppComponent
        AppComponentHolder.setAppComponent(DaggerAppComponent.builder().appModule(new AppModule(this)).build());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
