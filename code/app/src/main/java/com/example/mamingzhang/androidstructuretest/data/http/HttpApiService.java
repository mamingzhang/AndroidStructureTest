package com.example.mamingzhang.androidstructuretest.data.http;

import com.example.mamingzhang.androidstructuretest.data.http.entity.HttpResult;
import com.example.mamingzhang.androidstructuretest.data.http.entity.MovieSubject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by horsege on 2016/12/17.
 */

public interface HttpApiService {

    @GET("top250")
    Observable<HttpResult<List<MovieSubject>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
