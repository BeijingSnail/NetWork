package com.example.snail.network.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.snail.network.network.LoadingObserver;
import com.example.snail.network.network.ObservableSchedulers;
import com.example.snail.network.R;
import com.example.snail.network.network.RetrofitClient;
import com.example.snail.network.bean.UserBean;
import com.example.snail.network.photo.PhotoUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity implements PhotoUtils.OnPhotoResultListener, View.OnClickListener {
    private PhotoUtils photoUtils;
    private List<File> fileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fileList = new ArrayList<>();
        photoUtils = new PhotoUtils(this, true);
        photoUtils.setOnPhotoResultListener(this);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.select_bt).setOnClickListener(this);
        findViewById(R.id.uoload_imags_bt).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Map<String, String> requestMap = new HashMap<>();
                requestMap.put("mphone", "15142555427");
                requestMap.put("token", "666");
                String jsonStr = new Gson().toJson(requestMap);

                RetrofitClient.getInstance().getApiService().autoLogin(jsonStr)
                        .compose(new ObservableSchedulers<UserBean>())
                        .subscribe(new LoadingObserver<UserBean>(MainActivity.this) {
                            @Override
                            public void onNext(UserBean userBean) {
                                super.onNext(userBean);
                                TextView nameTv = findViewById(R.id.name);
                                nameTv.setText(userBean.acc.realName);
                            }
                        });
                break;

            case R.id.select_bt:
                photoUtils.selectPicture();
                break;
            case R.id.uoload_imags_bt:
                uploadPics();
                break;

        }
    }

    @Override
    public void onPhotoResult(Uri uri, File file) {
        fileList.add(file);
//        uploadPic(file);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        photoUtils.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 上传多张图片
     */
    private void uploadPics() {
        RequestBody mphone = RequestBody.create(MediaType.parse("multipart/form-data"), "15142555427");
        MultipartBody.Part[] filePart = new MultipartBody.Part[fileList.size()];

        for (int i = 0; i < fileList.size(); i++) {
            File file = fileList.get(i);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            filePart[i] = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        }

        RetrofitClient.getInstance().getApiService().uploadPicList(mphone, filePart).compose(new ObservableSchedulers<JsonObject>())
                .subscribe(new LoadingObserver<JsonObject>(this) {
                    @Override
                    public void onNext(JsonObject object) {
                        super.onNext(object);
                        Log.d("zzq", "next多张:" + object);
                    }
                });

    }

    /**
     * @param file
     * 上传单张图片
     */
    private void uploadPic(File file) {
        // 创建 RequestBody，用于封装构建MultipartBody
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part  和后端约定好Key，这里的partName是用image
        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), "15142555427");

        RetrofitClient.getInstance().getApiService().uploadPic(description, requestFile).compose(new ObservableSchedulers<JsonObject>())
                .subscribe(new LoadingObserver<JsonObject>(this) {
                    @Override
                    public void onNext(JsonObject object) {
                        super.onNext(object);
                        Log.d("zzq", "next:" + object);
                    }
                });

    }


}
