package com.example.mamingzhang.androidstructuretest.data.http;

import com.example.mamingzhang.androidstructuretest.data.http.entity.HttpResult;
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieRealmSubject;
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieSubject;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.example.mamingzhang.androidstructuretest.data.http.HttpResultCode.Code_NoLogin;

/**
 * Created by mamingzhang on 16/12/16.
 */

public class HttpRequestMethod {

    private Retrofit retrofit;

    private HttpApiService httpApiService;

    public HttpRequestMethod(Retrofit retrofit) {
        this.retrofit = retrofit;

        httpApiService = retrofit.create(HttpApiService.class);
    }

    /**
     * 对错误统一进行了封装，但是如果希望响应者能够接受错误码和错误信息，那么不要进行map转换
     *
     * @param subscriber
     * @param start
     * @param count
     */
    public void getTopMovie(Subscriber<List<MovieSubject>> subscriber, int start, int count) {
        httpApiService.getTopMovie(start, count)
                .map(new HttpApiFun<List<MovieSubject>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * @param subscriber
     * @param start
     * @param count
     */
    public void getTopRealmObjectMovie(Subscriber<List<MovieRealmSubject>> subscriber, int start, int count) {
        httpApiService.getTopRealmMovie(start, count)
                .map(new HttpApiFun<List<MovieRealmSubject>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    private static class HttpApiFun<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getCount() == 0) {
                throw new HttpApiException(Code_NoLogin, "");
            }

            return httpResult.getSubjects();
        }
    }
}
