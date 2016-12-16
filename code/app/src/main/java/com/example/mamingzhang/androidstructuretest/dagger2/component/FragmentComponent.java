package com.example.mamingzhang.androidstructuretest.dagger2.component;

import com.example.mamingzhang.androidstructuretest.dagger2.module.FragmentModule;
import com.example.mamingzhang.androidstructuretest.dagger2.scope.PerFragment;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import dagger.Subcomponent;

/**
 * Created by horsege on 2016/12/17.
 * <p>
 * 包含于ActivityComponent的组件，通常会在Activity内部的Fragment中使用
 */

@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(BaseFragment baseFragment);
}
