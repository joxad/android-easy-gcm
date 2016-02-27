package com.joxad.easygcm.utils;

import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by josh on 26/02/16.
 * Preferences class using EasyPref to store important data
 */
public class EasyGcmPrefs {

    private static final String PREFS_SENDER_ID = "PREFS_SENDER_ID";
    private static String PREFS_TOKEN = "PREFS_TOKEN";

    public static void saveSenderId(final String senderId) {
        Prefs.putString(PREFS_SENDER_ID, senderId);
    }

    public static void saveToken(String token) {
        Prefs.putString(PREFS_TOKEN, token);
    }

    public static String getToken() {
        return Prefs.getString(PREFS_TOKEN, "");
    }

    public static String getSenderId() {
        return Prefs.getString(PREFS_SENDER_ID, "");
    }
}
