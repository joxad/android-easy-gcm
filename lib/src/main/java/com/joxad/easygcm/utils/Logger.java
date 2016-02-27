package com.joxad.easygcm.utils;

import android.util.Log;

/**
 * Created by josh on 27/02/16.
 */
public class Logger {
    private static String TAG = "EasyGcmLog";

    private static boolean enabled = false;

    public static void enable(boolean enable) {
        enabled = enable;
    }

    public static void d(String message) {
        if (enabled)
            Log.d(TAG, message);
    }

    public static void w(String message) {
        if (enabled)
            Log.w(TAG, message);
    }

    public static void e(String message) {
        if (enabled) Log.e(TAG, message);
    }
}


