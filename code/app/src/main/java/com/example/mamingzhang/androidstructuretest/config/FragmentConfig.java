package com.example.mamingzhang.androidstructuretest.config;

import com.example.mamingzhang.androidstructuretest.fragment.BasicExampleFragment;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mamingzhang on 16/12/16.
 */

public class FragmentConfig {

    public static final Map<String, Class<? extends BaseFragment>> ExampleFragment;

    static {
        ExampleFragment = new LinkedHashMap<>();
        ExampleFragment.put("Dagger2及Http封装验证", BasicExampleFragment.class);
    }
}
