package com.joxad.easygcm;

import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;
import com.joxad.easygcm.model.Push;
import com.joxad.easygcm.utils.Logger;

/***
 *
 */
public class GCMService extends GcmListenerService {
    private static final String TAG = GCMService.class.getSimpleName();

    @Override
    public void onMessageReceived(String from, Bundle data) {
        Push push = new Push(from, data);
        EasyGcm.onReceive(push);

        Logger.d("Message received " + data.toString());
    }


}
