package com.example.mamingzhang.androidstructuretest.data.http;

import static com.example.mamingzhang.androidstructuretest.data.http.HttpResultCode.Code_NoLogin;

/**
 * Created by horsege on 2016/12/17.
 */

public class HttpApiException extends RuntimeException {

    private int httpResultCode;

    public HttpApiException(int code, String msg) {
        super(reProcessCodeMsg(code, msg));

        httpResultCode = code;
    }

    private static String reProcessCodeMsg(int code, String msg) {
        String resultMsg;

        switch (code) {
            case Code_NoLogin:
                resultMsg = "未登录，请先登录";
                break;
            default:
                resultMsg = "未知错误";
                break;
        }

        return resultMsg;
    }

    public int getHttpResultCode() {
        return httpResultCode;
    }
}
