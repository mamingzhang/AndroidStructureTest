package com.example.mamingzhang.androidstructuretest.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.activity.base.BaseActivity;
import com.example.mamingzhang.androidstructuretest.activity.base.BaseFragmentContainerActivity;
import com.example.mamingzhang.androidstructuretest.adapter.MainAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO：ButterKnife当Adapter为内部类的时候不生效，具体见提交commit20659ca
        listView.setAdapter(new MainAdapter());
    }

    @OnItemClick(R.id.listView)
    public void onItemClick(int positon) {
        BaseFragmentContainerActivity.actionStart(this, listView.getAdapter().getItem(positon).toString());
    }
}
