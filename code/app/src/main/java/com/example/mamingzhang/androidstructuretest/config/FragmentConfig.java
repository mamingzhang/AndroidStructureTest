package com.example.mamingzhang.androidstructuretest.config;

import com.example.mamingzhang.androidstructuretest.fragment.BasicExampleFragment;
import com.example.mamingzhang.androidstructuretest.fragment.BasicLocalExampleFragment;
import com.example.mamingzhang.androidstructuretest.fragment.BasicMovieRealmExampleFragment;
import com.example.mamingzhang.androidstructuretest.fragment.BasicRealmExampleFragment;
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
        ExampleFragment.put("MockServer本地请求验证", BasicLocalExampleFragment.class);
        ExampleFragment.put("Realm数据库数据更新机制验证", BasicRealmExampleFragment.class);
        ExampleFragment.put("Realm及Gson自动解析相关验证", BasicMovieRealmExampleFragment.class);
    }
}
