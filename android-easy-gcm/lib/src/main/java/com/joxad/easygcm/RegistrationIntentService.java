package com.joxad.easygcm;

import android.app.IntentService;
import android.content.Intent;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.joxad.easygcm.utils.EasyGcmPrefs;
import com.joxad.easygcm.utils.Logger;

/***
 * RegistrationService Used to get the Token of our device.
 */
public class RegistrationIntentService extends IntentService {
    private static final String TAG = RegistrationIntentService.class.getSimpleName();

    public RegistrationIntentService() {
        super(TAG);
    }

    protected String token = "";

    @Override
    protected void onHandleIntent(Intent intent) {

        try {
            InstanceID instanceID = InstanceID.getInstance(this);
            token = instanceID.getToken(EasyGcmPrefs.getSenderId(),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
        } catch (Exception e) {
            Logger.e(e.getMessage());
        }

        EasyGcmPrefs.saveToken(token);
        EasyGcm.onTokenReceived(token);


    }

}
