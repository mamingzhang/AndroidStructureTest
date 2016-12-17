package com.example.mamingzhang.androidstructuretest.data.http.subscriber;

import android.content.Context;
import android.widget.Toast;

import com.example.mamingzhang.androidstructuretest.data.http.HttpApiException;

import rx.Subscriber;

/**
 * Created by horsege on 2016/12/17.
 * <p>
 * 自己处理错误信息，通过Toast弹出错误提示
 */

public class ToastProgressSubscriber<T> extends Subscriber<T> {

    private Context context;

    private IHttpResultWithoutCodeMsg httpResultWithoutCodeMsg;

    public ToastProgressSubscriber(Context context, IHttpResultWithoutCodeMsg httpResultWithoutCodeMsg) {
        this.context = context;
        this.httpResultWithoutCodeMsg = httpResultWithoutCodeMsg;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpApiException) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "无网络或者网络信号差，请稍后重试", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNext(T t) {
        if (httpResultWithoutCodeMsg != null) {
            httpResultWithoutCodeMsg.onHttpResult(t);
        }
    }
}
