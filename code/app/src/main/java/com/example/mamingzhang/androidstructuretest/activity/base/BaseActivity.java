package com.example.mamingzhang.androidstructuretest.activity.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mamingzhang.androidstructuretest.dagger2.AppComponentHolder;
import com.example.mamingzhang.androidstructuretest.dagger2.component.ActivityComponent;
import com.example.mamingzhang.androidstructuretest.dagger2.component.DaggerActivityComponent;
import com.example.mamingzhang.androidstructuretest.data.http.HttpRequestMethod;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

public class BaseActivity extends AppCompatActivity {

    /**
     * 用于完成和BaseActivity相关的依赖注入器
     */
    private ActivityComponent activityComponent;

    /**
     * 按需注入
     */
    @Inject
    @Named("Remote")
    Provider<HttpRequestMethod> remoteHttpRequestMethodProvides;

    @Inject
    @Named("Local")
    Provider<HttpRequestMethod> localHttpRequestMethodProvides;

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
     * 返回Http请求实例
     *
     * @return
     */
    protected HttpRequestMethod getRemoteHttpRequestMethod() {
        return remoteHttpRequestMethodProvides.get();
    }

    /**
     * 返回本地Http请求实例
     *
     * @return
     */
    protected HttpRequestMethod getLocalHttpRequestMethod() {
        return localHttpRequestMethodProvides.get();
    }

    /**
     * 初始化ActivityCompoent，并且完成注入
     */
    private void initActivityComponent() {
        activityComponent = DaggerActivityComponent.builder().appComponent(AppComponentHolder.getAppComponent()).build();
        activityComponent.inject(this);
    }
}
