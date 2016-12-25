package com.example.mamingzhang.androidstructuretest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.adapter.BaseMovieDisplayAdapter;
import com.example.mamingzhang.androidstructuretest.adapter.BasicMovieRealmExampleAdapter;
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieRealmAvatars;
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieRealmCast;
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieRealmSubject;
import com.example.mamingzhang.androidstructuretest.data.http.realm.entity.RealmString;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.IHttpResultWithoutCodeMsg;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.ToastProgressSubscriber;
import com.example.mamingzhang.androidstructuretest.data.manager.basicrealm.BasicRealm;
import com.example.mamingzhang.androidstructuretest.data.manager.basicrealm.entity.BasicRealmEntity;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseMovieDisplayFragment;
import com.example.mamingzhang.androidstructuretest.utils.DebugUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by mamingzhang on 16/12/19.
 * <p>
 * 基于Gson自解析RealObject实体以及嵌套RealmObject进行验证，同时对于嵌套ReamObject的存储、查询和删除进行验证
 * 仅用于验证，其实体从实际上来说不合理
 */

public class BasicMovieRealmExampleFragment extends BaseFragment implements IHttpResultWithoutCodeMsg<List<MovieRealmSubject>> {

    private Unbinder butterKnifeUnBinder;

    @BindView(R.id.moviedisplay_recycleview)
    RecyclerView recyclerView;

    private BasicMovieRealmExampleAdapter baseMovieDisplayAdapter;

    private Realm basicRealm;

    private RealmResults<MovieRealmSubject> realmResults;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        basicRealm = BasicRealm.getBasicRealm();
    }

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_basicrealmmovie;
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);

        butterKnifeUnBinder = ButterKnife.bind(this, rootView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));

        baseMovieDisplayAdapter = new BasicMovieRealmExampleAdapter(getActivity());
        recyclerView.setAdapter(baseMovieDisplayAdapter);
    }

    @Override
    protected void initData() {
        realmResults = basicRealm.where(MovieRealmSubject.class).findAllAsync();
        realmResults.addChangeListener(new RealmChangeListener<RealmResults<MovieRealmSubject>>() {
            @Override
            public void onChange(RealmResults<MovieRealmSubject> element) {
                baseMovieDisplayAdapter.notifyDataSetChanged();
            }
        });

        baseMovieDisplayAdapter.refreshSource(realmResults);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (basicRealm != null) {
            basicRealm.close();
            basicRealm = null;
        }
    }

    @OnClick(R.id.loadfromnet_btn)
    public void onLoadFromNet() {
        getRemoteHttpRequestMethod().getTopRealmObjectMovie(new ToastProgressSubscriber<List<MovieRealmSubject>>(getContext(), this), 0, 20);
    }

    @OnClick(R.id.delfromdb_btn1)
    public void onDelFromDb1() {
        basicRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(MovieRealmSubject.class);
                realm.delete(MovieRealmAvatars.class);
                realm.delete(MovieRealmCast.class);
                realm.delete(RealmString.class);
            }
        });
    }

    @OnClick(R.id.delfromdb_btn2)
    public void onDelFromDb2() {
        basicRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<MovieRealmSubject> delRealmResults = basicRealm.where(MovieRealmSubject.class).findAll();
                delRealmResults.deleteAllFromRealm();
            }
        });
    }

    @Override
    public void onHttpResult(final List<MovieRealmSubject> result) {
        basicRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(MovieRealmSubject.class);
                realm.delete(MovieRealmAvatars.class);
                realm.delete(MovieRealmCast.class);
                realm.delete(RealmString.class);

                realm.copyToRealm(result);
            }
        });
    }
}
