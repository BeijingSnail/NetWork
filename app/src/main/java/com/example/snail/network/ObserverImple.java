package com.example.snail.network;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import java.util.PriorityQueue;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by Snail on 2018/7/24.
 */

public class ObserverImple<T> extends DefaultSubscriber<T> {
    private Dialog mDialog;
    private Context mContext;

    public ObserverImple(Context context){
        this.mContext = context;

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    //    @Override
//    public void onSubscribe(Disposable d) {
//        //可以判断是否有网络 没有tost提示  给出dialog 手动调用onComplete 在其中销毁dialog
//        Log.d("zzq", "Imple-->onSubscribe");
//        mDialog = WeiboDialogUtils.createLoadingDialog(mContext, "加载中...");
//    }

    @Override
    public void onNext(T t) {
        Log.d("zzq", "Imple-->onNext");
    }

    @Override
    public void onError(Throwable e) {
        Log.d("zzq", "Imple-->onError" + e);
    }

    @Override
    public void onComplete() {
        WeiboDialogUtils.closeDialog(mDialog);
        Log.d("zzq", "Imple-->onComplete");
    }
}
