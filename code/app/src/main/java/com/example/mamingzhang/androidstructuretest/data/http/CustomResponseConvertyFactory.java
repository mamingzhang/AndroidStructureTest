package com.example.mamingzhang.androidstructuretest.data.http;

import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by horsege on 2016/12/17.
 */

public class CustomResponseConvertyFactory extends Converter.Factory {
    /**
     * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static CustomResponseConvertyFactory create() {
        return create(HttpCustomGson.createGson());
    }

    /**
     * Create an instance using {@code gson} for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static CustomResponseConvertyFactory create(Gson gson) {
        return new CustomResponseConvertyFactory(gson);
    }

    private final Gson gson;

    private CustomResponseConvertyFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                                                            Retrofit retrofit) {
        return new CustomGsonResponseBodyConverter<>(gson, type);
    }

}
