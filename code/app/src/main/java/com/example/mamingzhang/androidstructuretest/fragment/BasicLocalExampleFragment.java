package com.example.mamingzhang.androidstructuretest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieSubject;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.HttpProgressSubscriber;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.IHttpResultCodeWithCodeMsg;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.IHttpResultWithoutCodeMsg;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.ToastProgressSubscriber;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseMovieDisplayFragment;

import java.util.List;

import static com.example.mamingzhang.androidstructuretest.data.http.HttpResultCode.Code_Success;

/**
 * Created by horsege on 2016/12/25.
 */

public class BasicLocalExampleFragment extends BaseMovieDisplayFragment implements IHttpResultCodeWithCodeMsg<List<MovieSubject>> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLocalHttpRequestMethod().getTopMovie(new HttpProgressSubscriber<List<MovieSubject>>(getContext(), this), 0, 20);
    }

    @Override
    public void onHttpResult(int code, String msg, List<MovieSubject> result) {
        if (code == Code_Success) {
            refreshSource(result);
        } else {
            refreshFailed(code, msg);
        }
    }
}
