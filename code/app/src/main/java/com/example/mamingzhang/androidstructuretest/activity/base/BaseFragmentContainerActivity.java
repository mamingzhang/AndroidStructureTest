package com.example.mamingzhang.androidstructuretest.activity.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.config.FragmentConfig;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

/**
 * 用于装在测试用Fragment容器Activity
 */
public class BaseFragmentContainerActivity extends BaseActivity {

    public static void actionStart(Context context, String fragmengConfigKey) {
        Intent intent = new Intent(context, BaseFragmentContainerActivity.class);
        intent.putExtra("FragmentConfigKey", fragmengConfigKey);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_fragment_container);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initFragment(getIntent().getStringExtra("FragmentConfigKey"));
    }

    /**
     * 加载对应的Fragment
     * @param fragmentConfigKey
     */
    private void initFragment(String fragmentConfigKey) {
        BaseFragment baseFragment = BaseFragment.newInstance(FragmentConfig.ExampleFragment.get(fragmentConfigKey));
        if (baseFragment != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, baseFragment).commitAllowingStateLoss();
        }
    }
}
