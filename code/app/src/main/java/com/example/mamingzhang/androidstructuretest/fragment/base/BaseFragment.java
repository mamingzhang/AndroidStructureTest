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
import javax.inject.Provider;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    public static BaseFragment newInstance(Class<? extends BaseFragment> framentCls) {
        try {
            Class[] paramCls = {};
            Object[] params = {};

            Constructor<? extends BaseFragment> constructor = framentCls.getConstructor(paramCls);
            return constructor.newInstance(params);
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
    Provider<HttpRequestMethod> httpRequestMethodProvides;

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
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

    /**
     * 返回Http请求实例
     * @return
     */
    protected HttpRequestMethod getHttpRequestMethod() {
        return httpRequestMethodProvides.get();
    }

    /**
     * 初始化Fragment依赖注入Component
     */
    private void initFragmentComponent() {
        ((BaseActivity) getActivity()).getActivityComponent().getFragmentComponent().inject(this);
    }
}
