package com.example.mamingzhang.androidstructuretest.data.http.subscriber;

/**
 * Created by horsege on 2016/12/17.
 */

public interface IHttpResultWithoutCodeMsg<T> {
    void onHttpResult(T result);
}
