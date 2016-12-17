package com.example.mamingzhang.androidstructuretest.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mamingzhang.androidstructuretest.dagger2.AppComponentHolder;
import com.example.mamingzhang.androidstructuretest.dagger2.component.ActivityComponent;
import com.example.mamingzhang.androidstructuretest.dagger2.component.DaggerActivityComponent;

public class BaseActivity extends AppCompatActivity {

    /**
     * 用于完成和BaseActivity相关的依赖注入器
     */
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initActivityComponent();
    }

    /**
     * 返回对应于当前Activity的ActivityComponent，用于Fragment等相关注入操作
     *
     * @return
     */
    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    /**
     * 初始化ActivityCompoent，并且完成注入
     */
    private void initActivityComponent() {
        activityComponent = DaggerActivityComponent.builder().appComponent(AppComponentHolder.getAppComponent()).build();
        activityComponent.inject(this);
    }
}
