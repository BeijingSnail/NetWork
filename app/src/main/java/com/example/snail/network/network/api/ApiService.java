package com.example.snail.network.network.api;

import com.example.snail.network.bean.UserBean;
import com.google.gson.JsonObject;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;


public interface ApiService {
    //自動登陆
    @GET("getAccInfo")
    Observable<UserBean> autoLogin(@Query("appstr") String appstr);

    //上传头像(上传一张图片)
    @Multipart
    @POST("changeHeadPic")
    Observable<JsonObject> uploadPic(@Part("mphone") RequestBody description, @Part("file\"; filename=\"image1.png") RequestBody file);

//    //上传头像(上传一张图片) 也可以
//    @Multipart
//    @POST("changeHeadPic")
//    Observable<JsonObject> uploadPic(@Part("mphone") RequestBody description, @Part MultipartBody.Part file);

    //上传多张图片
    @Multipart
    @POST("uploadPic")
    Observable<JsonObject> uploadPicList(@Part("mphone") RequestBody description, @Part MultipartBody.Part[] file);
}
