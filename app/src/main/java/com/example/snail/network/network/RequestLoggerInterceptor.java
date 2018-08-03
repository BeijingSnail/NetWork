package com.example.snail.network.network;

import android.util.Log;

import java.io.IOException;
import java.net.URLDecoder;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Snail on 2018/7/26.
 * 拦截请求 打印请求的内容
 */

public class RequestLoggerInterceptor implements Interceptor {
    private final String TAG = RequestLoggerInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //将请求转码
        Log.d(TAG, "url = : " + URLDecoder.decode(String.valueOf(request.url()), "UTF-8"));
        Log.d(TAG, "method = : " + request.method());
        Log.d(TAG, "headers = : " + request.headers());
        Log.d(TAG, "body = : " + request.body());
        return chain.proceed(request);
    }
}
