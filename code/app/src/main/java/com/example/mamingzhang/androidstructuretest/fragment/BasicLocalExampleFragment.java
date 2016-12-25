package com.example.mamingzhang.androidstructuretest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieSubject;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.IHttpResultWithoutCodeMsg;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.ToastProgressSubscriber;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseMovieDisplayFragment;

import java.util.List;

/**
 * Created by horsege on 2016/12/25.
 */

public class BasicLocalExampleFragment extends BaseMovieDisplayFragment implements IHttpResultWithoutCodeMsg<List<MovieSubject>> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLocalHttpRequestMethod().getTopMovie(new ToastProgressSubscriber<List<MovieSubject>>(getContext(), this), 0, 20);
    }

    @Override
    public void onHttpResult(List<MovieSubject> result) {
        refreshSource(result);
    }
}
