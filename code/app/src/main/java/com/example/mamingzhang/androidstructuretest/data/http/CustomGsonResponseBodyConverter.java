package com.example.mamingzhang.androidstructuretest.data.http;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by horsege on 2016/12/17.
 */

public class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    CustomGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        return gson.fromJson(response, type);
    }
}
