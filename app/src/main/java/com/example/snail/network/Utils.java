package com.example.snail.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Snail on 2018/8/1.
 */

public class Utils {

    private static Toast mToast;
    public static void showToast(Context context, String content) {
        if (mToast == null) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(content);
        }
        mToast.show();
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                return info.isAvailable();
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


}
