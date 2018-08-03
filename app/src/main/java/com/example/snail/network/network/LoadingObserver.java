package com.example.snail.network.network;

import android.app.Dialog;
import android.content.Context;

import com.example.loading.LoadingUtils;

import io.reactivex.disposables.Disposable;

/**
 * Created by Snail on 2018/8/2.
 */

public class LoadingObserver<T> extends BaseObserver<T> {

    private Dialog mLoadingDialog;

    public LoadingObserver(Context context) {
        super(context);
        mLoadingDialog = LoadingUtils.getInstance(context);
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        LoadingUtils.show(mLoadingDialog);
        super.onSubscribe(disposable);
    }

    @Override
    public void onNext(T t) {
        super.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        LoadingUtils.dismiss(mLoadingDialog);
    }

    @Override
    public void onComplete() {
        super.onComplete();
        LoadingUtils.dismiss(mLoadingDialog);
    }
}
