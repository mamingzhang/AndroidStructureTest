package com.example.mamingzhang.androidstructuretest.fragment.base;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mamingzhang.androidstructuretest.R;
import com.example.mamingzhang.androidstructuretest.adapter.BaseMovieDisplayAdapter;
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieSubject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by horsege on 2016/12/17.
 */

public class BaseMovieDisplayFragment extends BaseFragment {

    private Unbinder butterKnifeUnBinder;

    @BindView(R.id.moviedisplay_recycleview)
    RecyclerView recyclerView;

    private BaseMovieDisplayAdapter baseMovieDisplayAdapter;

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

        baseMovieDisplayAdapter = new BaseMovieDisplayAdapter(getActivity());
        recyclerView.setAdapter(baseMovieDisplayAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (butterKnifeUnBinder != null) {
            butterKnifeUnBinder.unbind();
        }
    }

    protected void refreshSource(List<MovieSubject> movieSubjectList) {
        if (baseMovieDisplayAdapter != null) {
            baseMovieDisplayAdapter.refreshSource(movieSubjectList);
        }
    }
}
