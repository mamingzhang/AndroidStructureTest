package com.example.mamingzhang.androidstructuretest.fragment.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.activity.base.BaseActivity;
import com.example.mamingzhang.androidstructuretest.data.http.HttpRequestMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    public static BaseFragment newInstance(Class<? extends BaseFragment> framentCls) {
        try {
            Class[] paramCls = {};
            Object[] params = {};

            Constructor<? extends BaseFragment> constructor = framentCls.getConstructor(paramCls);
            BaseFragment baseFragment = constructor.newInstance(params);
            baseFragment.configArguments();
            return baseFragment;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 按需注入
     */
    @Inject
    @Named("Remote")
    Provider<HttpRequestMethod> remoteHttpRequestMethodProvides;

    @Inject
    @Named("Local")
    Provider<HttpRequestMethod> localHttpRequestMethodProvides;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initFragmentComponent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayouRes(), container, false);
        initView(rootView);
        initData();
        return rootView;
    }

    /**
     * 返回Fragment对应的布局文件ID
     *
     * @return
     */
    protected abstract int getLayouRes();

    /**
     * 解析View及相关View初始化操作
     *
     * @param rootView
     */
    protected void initView(View rootView) {

    }

    /**
     * 数据加载
     */
    protected void initData() {

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
     * 配置启动参数
     */
    protected void configArguments() {

    }

    /**
     * 初始化Fragment依赖注入Component
     */
    private void initFragmentComponent() {
        ((BaseActivity) getActivity()).getActivityComponent().getFragmentComponent().inject(this);
    }
}
