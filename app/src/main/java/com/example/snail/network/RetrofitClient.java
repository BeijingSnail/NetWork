package com.example.snail.network;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Snail on 2018/7/24.
 */

public class RetrofitClient {
    public static final String BASEURL = "http://101.201.145.159:9090/WebRoot/";

    private static RetrofitClient instance;

    private Retrofit builder;
    private ApiService mApiService;

    private RetrofitClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//日志级别

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .readTimeout(3000, TimeUnit.MILLISECONDS)
                .writeTimeout(3000, TimeUnit.MILLISECONDS)
                .connectTimeout(3000, TimeUnit.MILLISECONDS);


        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(new RequestLoggerInterceptor());
            okHttpBuilder.addNetworkInterceptor(loggingInterceptor);
        }

        builder = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApiService = builder.create(ApiService.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    public ApiService getApiService() {
        return mApiService;
    }

}
