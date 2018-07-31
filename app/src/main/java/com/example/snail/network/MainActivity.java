package com.example.snail.network;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> requestMap = new HashMap<>();
                requestMap.put("mphone", "15142555427");
                requestMap.put("token", "666");
                String jsonStr = new Gson().toJson(requestMap);
                RetrofitClient.getInstance().getApiService().autoLogin(jsonStr)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ObserverImple<UserBean>(MainActivity.this) {
                            @Override
                            public void onNext(UserBean userBean) {
                                super.onNext(userBean);
                                Log.d("zzq", "activity-->onNext" + userBean.acc.realName);
                            }
                        });
            }
        });
    }

}
