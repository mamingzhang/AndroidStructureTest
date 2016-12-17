package com.example.mamingzhang.androidstructuretest.data.http.subscriber;

/**
 * Created by horsege on 2016/12/17.
 */

public interface IHttpResultCodeWithCodeMsg<T> {
    void onHttpResult(int code, String msg, T result);
}
