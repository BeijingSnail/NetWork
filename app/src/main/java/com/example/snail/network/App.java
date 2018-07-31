package com.example.snail.network;

import android.app.Application;

/**
 * Created by Snail on 2018/7/31.
 */

public class App extends Application {
    public static App instances;
    @Override
    public void onCreate() {
        super.onCreate();

        instances = this;
    }

    public static App getInstances() {
        return instances;
    }
}
