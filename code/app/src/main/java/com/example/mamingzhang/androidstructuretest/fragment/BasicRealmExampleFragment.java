package com.example.mamingzhang.androidstructuretest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.adapter.BasicRealmAdapter;
import com.example.mamingzhang.androidstructuretest.data.manager.basicrealm.BasicRealm;
import com.example.mamingzhang.androidstructuretest.data.manager.basicrealm.BasicRealmDataManager;
import com.example.mamingzhang.androidstructuretest.data.manager.basicrealm.entity.BasicRealmEntity;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by horsege on 2016/12/17.
 * <p>
 * 基本的Realm数据库用法体验，基于Realm的数据更新机制做验证
 * <p>
 * 数据通过数据库直接获取，后台数据层动态更新数据，利用Reaml自身机制实现数据刷新
 */

public class BasicRealmExampleFragment extends BaseFragment {

    private Unbinder butterKnifeUnBinder;

    @BindView(R.id.basicrealm_listview)
    ListView basicRealmListView;

    private RealmResults<BasicRealmEntity> realmResults;

    private BasicRealmAdapter basicRealmAdapter;

    private Realm basicRealm;

    private BasicRealmDataManager basicRealmDataManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        basicRealm = BasicRealm.getBasicRealm();
    }

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_basicrealm;
    }

    @Override
    protected void initView(View rootView) {
        butterKnifeUnBinder = ButterKnife.bind(this, rootView);
    }

    @Override
    protected void initData() {
        realmResults = basicRealm.where(BasicRealmEntity.class).findAllAsync();
        realmResults.sort("title");
        realmResults.addChangeListener(new RealmChangeListener<RealmResults<BasicRealmEntity>>() {
            @Override
            public void onChange(RealmResults<BasicRealmEntity> element) {
                basicRealmAdapter.notifyDataSetChanged();
            }
        });

        basicRealmAdapter = new BasicRealmAdapter(realmResults);
        basicRealmListView.setAdapter(basicRealmAdapter);

        basicRealmDataManager = new BasicRealmDataManager();
        basicRealmDataManager.startSimulate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }

        realmResults.removeChangeListeners();

        basicRealmDataManager.stopSimulate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (basicRealm != null) {
            basicRealm.close();
            basicRealm = null;
        }
    }
}
