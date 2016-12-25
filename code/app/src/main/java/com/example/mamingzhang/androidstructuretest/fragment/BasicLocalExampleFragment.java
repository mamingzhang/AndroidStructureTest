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
 * <p>
 * 相关文档参考资料：
 * 1. https://github.com/dreamhead/moco/blob/master/moco-doc/apis.md
 * 2. http://www.coderli.com/mock-server-moco-guide/
 * 3. http://www.2cto.com/kf/201610/554333.html
 * 4. http://sanjay-f.github.io/2015/12/07/Android%E6%B5%8B%E8%AF%95%E6%95%99%E7%A8%8B13--%E6%A8%A1%E6%8B%9F%E6%9C%8D%E5%8A%A1%E5%99%A8MockServer%E4%B9%8BMoco%E8%AF%A6%E7%BB%86%E4%BB%8B%E7%BB%8D/
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
