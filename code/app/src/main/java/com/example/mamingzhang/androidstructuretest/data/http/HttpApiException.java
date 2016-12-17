package com.example.mamingzhang.androidstructuretest.data.http;

/**
 * Created by horsege on 2016/12/17.
 */

public class HttpApiException extends RuntimeException {
    public static final int Code_NoLogin = 10001;

    public HttpApiException(int code, String msg) {
        super(reProcessCodeMsg(code, msg));
    }

    public HttpApiException(String msg) {
        super(msg);
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
}
