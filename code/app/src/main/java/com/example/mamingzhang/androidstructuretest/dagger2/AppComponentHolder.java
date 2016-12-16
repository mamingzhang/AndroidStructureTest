package com.example.mamingzhang.androidstructuretest.dagger2;

import com.example.mamingzhang.androidstructuretest.dagger2.component.AppComponent;

/**
 * Created by mamingzhang on 16/12/16.
 */

public class AppComponentHolder {
    private static AppComponent appComponent = null;

    public static void setAppComponent(AppComponent appComponent) {
        AppComponentHolder.appComponent = appComponent;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
