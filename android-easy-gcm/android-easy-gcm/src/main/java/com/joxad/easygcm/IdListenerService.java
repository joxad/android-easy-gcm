package com.joxad.easygcm;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by joxda_000 on 26/09/2015.
 */
public class IdListenerService extends InstanceIDListenerService {

    public void onTokenRefresh() {

        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
}
