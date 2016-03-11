package com.joxad.easygcmsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.joxad.easygcm.EasyGcm;
import com.joxad.easygcm.error.PlayServiceNotAvailableException;
import com.joxad.easygcm.listener.IPushListener;
import com.joxad.easygcm.listener.ITokenListener;
import com.joxad.easygcm.model.Push;
import com.joxad.easygcm.notification.EasyNotification;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            new EasyGcm.Builder().context(this).senderId(getString(R.string.app_senderid)).enableLog(true).build();
            // Could use
            // new EasyGcm.Builder().context(this).senderId(R.string.app_senderid).enableLog(true).build();
        } catch (PlayServiceNotAvailableException e) {
            e.printStackTrace();
        }
        EasyNotification.show(1, EasyNotification.generate(null, "Title", R.drawable.common_ic_googleplayservices, "Message", "SummaryText", true));

        EasyGcm.setTokenListener(new ITokenListener() {
            @Override
            public void onReceived(String token) {
                Log.d(MainActivity.class.getSimpleName(), token);
            }
        });

        EasyGcm.setPushListener(new IPushListener() {
            @Override
            public void onReceive(Push push) {
                Log.d(MainActivity.class.getSimpleName(), push.getData().toString());
                EasyNotification.show(1,EasyNotification.generate(null,"Title",R.drawable.common_ic_googleplayservices,"Message","SummaryText",true));
            }
        });

    }
}
