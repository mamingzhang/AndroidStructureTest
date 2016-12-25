package com.example.mamingzhang.androidstructuretest.dagger2.module;

import android.app.Application;
import android.content.Context;
import android.support.v4.view.ViewCompat;

import com.example.mamingzhang.androidstructuretest.data.http.HttpOkHttpClient;
import com.example.mamingzhang.androidstructuretest.data.http.HttpRequestMethod;
import com.example.mamingzhang.androidstructuretest.data.http.HttpRetrofit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by mamingzhang on 16/12/16.
 */

@Module
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Context provideApplicationContext() {
        return application;
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(Context context) {
        return new HttpOkHttpClient(context).getOkHttpClient();
    }

    /**
     * Named注解主要是为了区分不同的Retrofit返回，对应于不同的baseUrl基准的Retorfit
     *
     * @param okHttpClient
     * @return
     */
    @Singleton
    @Provides
    @Named("Remote")
    public Retrofit provideRemoteHttpApiRetrofit(OkHttpClient okHttpClient) {
        return new HttpRetrofit().getApiRetrofit(okHttpClient);
    }

    @Singleton
    @Provides
    @Named("Local")
    public Retrofit provideLocalHttpApiRetrofit(OkHttpClient okHttpClient) {
        return new HttpRetrofit().getLocalApiRetrofit(okHttpClient);
    }

    @Singleton
    @Provides
    @Named("Remote")
    public HttpRequestMethod provideRemoteHttpRequestMenthod(@Named("Remote") Retrofit retrofit) {
        return new HttpRequestMethod(retrofit);
    }

    @Singleton
    @Provides
    @Named("Local")
    public HttpRequestMethod provideLocalHttpRequestMenthod(@Named("Local") Retrofit retrofit) {
        return new HttpRequestMethod(retrofit);
    }
}
