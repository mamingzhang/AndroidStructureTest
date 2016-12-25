package com.example.mamingzhang.androidstructuretest.data.http.subscriber;

import android.content.Context;
import android.widget.Toast;

import com.example.mamingzhang.androidstructuretest.data.http.HttpApiException;

import rx.Subscriber;

import static com.example.mamingzhang.androidstructuretest.data.http.HttpResultCode.Code_Network;
import static com.example.mamingzhang.androidstructuretest.data.http.HttpResultCode.Code_Success;

/**
 * Created by horsege on 2016/12/25.
 */

public class HttpProgressSubscriber<T> extends Subscriber<T> {

    private Context context;

    private IHttpResultCodeWithCodeMsg httpResultWithCodeMsg;

    public HttpProgressSubscriber(Context context, IHttpResultCodeWithCodeMsg httpResultWithCodeMsg) {
        this.context = context;
        this.httpResultWithCodeMsg = httpResultWithCodeMsg;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        int code;
        String msg;

        if (e instanceof HttpApiException) {
            code = ((HttpApiException) e).getHttpResultCode();
            msg = e.getMessage();
        } else {
            code = Code_Network;
            msg = e.getMessage();
        }

        if (httpResultWithCodeMsg != null) {
            httpResultWithCodeMsg.onHttpResult(code, msg, null);
        }
    }

    @Override
    public void onNext(T t) {
        if (httpResultWithCodeMsg != null) {
            httpResultWithCodeMsg.onHttpResult(Code_Success, null, t);
        }
    }
}
