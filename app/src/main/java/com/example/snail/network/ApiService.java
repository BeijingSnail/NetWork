package com.example.snail.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：文欢 on 2017/6/28 10:10
 * 邮箱：whbeijixiong@gmail.com
 */

public interface ApiService {
    //自動登陆
    @GET("getAccInfo")
    Observable<UserBean> autoLogin(@Query("appstr") String appstr);



}
