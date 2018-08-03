package com.example.snail.network.network;

import android.content.Context;
import android.util.Log;

import com.example.snail.network.Utils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Snail on 2018/7/24.
 */

public class BaseObserver<T> implements Observer<T> {
    private String TAG = BaseObserver.class.getSimpleName();
    private Context mContext;
    private Disposable disposable;

    public BaseObserver(Context context) {
        this.mContext = context;
    }

    @Override
    public void onSubscribe(Disposable disposable) {
        this.disposable = disposable;
        if (!Utils.isNetworkAvailable(mContext)) {
            onComplete();
            Utils.showToast(mContext, "当前网络不可用");
        }
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "BaseObserver-->onError:" + e);
        disposeIt();
    }

    @Override
    public void onComplete() {
        disposeIt();
    }

    /**
     * 实现断开Observer 与 Observable 的连接
     */
    private void disposeIt() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }
    }


}
