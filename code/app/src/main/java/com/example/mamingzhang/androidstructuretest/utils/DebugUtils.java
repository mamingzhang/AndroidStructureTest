package com.example.mamingzhang.androidstructuretest.utils;

import android.util.Log;

/**
 * Created by horsege on 2016/12/17.
 */

public class DebugUtils {
    private static final String TAG = "mmz";

    private static final boolean bDebug = true;

    public static void LogV(String msg) {
        if (bDebug) {
            Log.v(TAG, msg);
        }
    }

    public static void LogE(String msg) {
        if (bDebug) {
            Log.e(TAG, msg);
        }
    }

    public static void LogI(String msg) {
        if (bDebug) {
            Log.i(TAG, msg);
        }
    }
}
