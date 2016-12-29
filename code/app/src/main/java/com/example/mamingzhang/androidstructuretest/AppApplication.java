package com.example.mamingzhang.androidstructuretest;

import android.app.Application;
import android.content.Context;

import com.example.mamingzhang.androidstructuretest.dagger2.AppComponentHolder;
import com.example.mamingzhang.androidstructuretest.dagger2.component.DaggerAppComponent;
import com.example.mamingzhang.androidstructuretest.dagger2.module.AppModule;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;

/**
 * Created by mamingzhang on 16/12/16.
 */

public class AppApplication extends Application {

    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        //初始化Realm
        Realm.init(this);

        //增加Stetho插件调试，用于查看网络请求以及Realm数据库
        //TODO: Realm数据库在Chrom开发者调试工具中无法正常查看
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

        //初始化顶级Component也就是AppComponent
        AppComponentHolder.setAppComponent(DaggerAppComponent.builder().appModule(new AppModule(this)).build());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static Application getApplication() {
        return application;
    }
}
