package com.example.mamingzhang.androidstructuretest.dagger2.component;

import com.example.mamingzhang.androidstructuretest.activity.base.BaseActivity;
import com.example.mamingzhang.androidstructuretest.dagger2.module.ActivityModule;
import com.example.mamingzhang.androidstructuretest.dagger2.scope.PerActivity;

import dagger.Component;

/**
 * Created by mamingzhang on 16/12/16.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);
}
