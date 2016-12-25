package com.example.mamingzhang.androidstructuretest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieSubject;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.IHttpResultWithoutCodeMsg;
import com.example.mamingzhang.androidstructuretest.data.http.subscriber.ToastProgressSubscriber;
import com.example.mamingzhang.androidstructuretest.fragment.base.BaseMovieDisplayFragment;

import java.util.List;

/**
 * Created by mamingzhang on 16/12/16.
 * <p>
 * 用于验证基本的Dagger2、Http封装等逻辑
 * <p>
 * 相关文档参考资料：
 * 1. http://www.jianshu.com/p/47c7306b2994
 * 2. http://gank.io/post/56e80c2c677659311bed9841
 * 3. http://gank.io/post/560e15be2dca930e00da1083
 * 4. http://www.jianshu.com/p/5b8b1062866b
 */

public class BasicExampleFragment extends BaseMovieDisplayFragment implements IHttpResultWithoutCodeMsg<List<MovieSubject>> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getRemoteHttpRequestMethod().getTopMovie(new ToastProgressSubscriber<List<MovieSubject>>(getContext(), this), 0, 20);
    }

    @Override
    public void onHttpResult(List<MovieSubject> result) {
        refreshSource(result);
    }
}
