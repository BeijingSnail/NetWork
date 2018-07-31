package com.example.snail.network;

import android.util.Log;

import java.io.IOException;
import java.net.URLDecoder;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Snail on 2018/7/26.
 */

public class RequestLoggerInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //将请求转码
        Log.d("zzq", "url = : " + URLDecoder.decode(String.valueOf(request.url()),"UTF-8"));
        Log.d("zzq", "method = : " + request.method());
        Log.d("zzq", "headers = : " + request.headers());
        Log.d("zzq", "body = : " + request.body());

        return chain.proceed(request);
    }
}
