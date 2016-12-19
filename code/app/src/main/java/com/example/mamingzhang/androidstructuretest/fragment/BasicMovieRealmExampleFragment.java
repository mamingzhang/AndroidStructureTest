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
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieRealmSubject;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.IHttpResultWithoutCodeMsg;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.ToastProgressSubscriber;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseFragment;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseMovieDisplayFragment;
import com.example.mamingzhang.androidstructuretest.utils.DebugUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mamingzhang on 16/12/19.
 */

public class BasicMovieRealmExampleFragment extends BaseFragment implements IHttpResultWithoutCodeMsg<List<MovieRealmSubject>> {

    private Unbinder butterKnifeUnBinder;

    @BindView(R.id.moviedisplay_recycleview)
    RecyclerView recyclerView;

    private BasicMovieRealmExampleAdapter baseMovieDisplayAdapter;

    @Override
    protected int getLayouRes() {
        return R.layout.fragment_basemoviedisplay;
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getHttpRequestMethod().getTopRealmObjectMovie(new ToastProgressSubscriber<List<MovieRealmSubject>>(getContext(), this), 0, 20);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }

    @Override
    public void onHttpResult(List<MovieRealmSubject> result) {
        if (baseMovieDisplayAdapter != null) {
            baseMovieDisplayAdapter.refreshSource(result);
        }
    }
}
