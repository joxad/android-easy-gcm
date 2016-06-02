package com.joxad.easygcm.utils;

/**
 * Created by josh on 27/02/16.
 */
public class Logger {
    private static String TAG = "EasyGcmLog";

    private static boolean enabled = false;

    public static void enable(boolean enable) {
        com.orhanobut.logger.Logger.init(TAG);
        enabled = enable;
    }

    public static void d(String message) {
        if (enabled)
            com.orhanobut.logger.Logger.d(message);
    }

    public static void w(String message) {
        if (enabled)
            com.orhanobut.logger.Logger.w(message);
    }

    public static void e(String message) {
        if (enabled) com.orhanobut.logger.Logger.e(message);
    }
}


