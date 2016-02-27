package com.joxad.easygcm;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.joxad.easygcm.error.PlayServiceNotAvailableException;
import com.joxad.easygcm.listener.IPushListener;
import com.joxad.easygcm.listener.ITokenListener;
import com.joxad.easygcm.model.Push;
import com.joxad.easygcm.utils.EasyGcmPrefs;
import com.joxad.easygcm.utils.Logger;
import com.joxad.easygcm.utils.PlayServiceUtils;
import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by josh on 26/02/16.
 */
public class EasyGcm {
    protected static GoogleCloudMessaging gcm;
    protected static String senderId;
    private static IPushListener pushListener;
    private static ITokenListener tokenListener;

    /**
     * @param context
     * @param id
     * @param logEnabled
     * @throws PlayServiceNotAvailableException
     */
    private static void init(Context context, String id, boolean logEnabled) throws PlayServiceNotAvailableException {

        gcm = GoogleCloudMessaging.getInstance(context);
        senderId = id;
        Logger.enable(logEnabled);
        new Prefs.Builder()
                .setContext(context)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(EasyGcm.class.getName())
                .setUseDefaultSharedPreference(true)
                .build();

        EasyGcmPrefs.saveSenderId(senderId);

        if (PlayServiceUtils.checkPlayServices(context)) {
            Intent intent = new Intent(context, RegistrationIntentService.class);
            context.startService(intent);
        } else {
            Logger.e("PlayService Not Available");
            throw new PlayServiceNotAvailableException();
        }
    }

    /***
     * Needed Listener to handle the push
     *
     * @param listener
     */
    public static void setPushListener(IPushListener listener) {
        pushListener = listener;
    }

    /***
     * Needed Listener to handle the token
     *
     * @param listener
     */
    public static void setTokenListener(ITokenListener listener) {
        tokenListener = listener;
    }

    /***
     * @param push
     */
    protected static void onReceive(Push push) {
        Logger.d("Push received");
        if (pushListener != null) {
            pushListener.onReceive(push);
        }
    }


    /***
     * @param token
     */
    protected static void onTokenReceived(final String token) {
        Logger.d("Token Received :" + token);
        if (tokenListener != null) {
            tokenListener.onReceived(token);
        }
    }

    /***
     * Builder used to create our GCM Manager
     */
    public static class Builder {

        private Context mContext;
        private String mSenderId;
        private boolean logEnable = false;

        /**
         * Set the Context used to instantiate the EasyGcm
         *
         * @param context the application context
         * @return the {@link com.} object.EasyGcm
         */
        public Builder context(final Context context) {
            mContext = context;
            return this;
        }

        /**
         * Set the Context used to instantiate the EasyGcm
         *
         * @param senderId the identification of the GCM
         * @return the {@link com.} object.EasyGcm
         */
        public Builder senderId(final String senderId) {
            this.mSenderId = senderId;
            return this;
        }

        /**
         * Set the Context used to instantiate the EasyGcm
         *
         * @param logEnable the identification of the GCM
         * @return the {@link com.} object.EasyGcm
         */
        public Builder enableLog(final boolean logEnable) {
            this.logEnable = logEnable;
            return this;
        }


        /**
         * Initialize the SharedPreference instance to used in the application.
         *
         * @throws RuntimeException if Context has not been set.
         */
        public void build() throws PlayServiceNotAvailableException {
            if (mContext == null) {
                throw new RuntimeException("Context not set, please set context");
            }
            if (mSenderId == null) {
                throw new RuntimeException("Sender Id not set, please set the id");
            }


            EasyGcm.init(mContext, mSenderId, logEnable);
        }
    }

}

