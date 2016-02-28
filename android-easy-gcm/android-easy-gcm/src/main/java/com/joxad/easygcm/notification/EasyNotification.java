package com.joxad.easygcm.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by josh on 28/02/16.
 */
public class EasyNotification {

    protected static Context context;
    protected static NotificationManager notificationManager;

    private static void init(Context c) {
        context = c;
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }


    /***
     * @param pendingIntent : Intent used on the click of the notification :
     *                      Here is an example
     *                      Intent intent = new Intent(this, Activity.class);
     *                      if (screenRedirection != null && redirectParam != null) {
     *                      intent.putExtra(EXTRA_SCREEN_REDIRECTION, screenRedirection);
     *                      intent.putExtra(EXTRA_SCREEN_REDIRECTION_PARAM, redirectParam);
     *                      }
     *                      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
     *                      <p/>
     *                      PendingIntent pendingIntent = PendingIntent.getActivity(context, RESULTCODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
     * @param title
     * @param resourceIcon
     * @param message
     * @param summaryText
     * @param autocancel
     * @return a notification to show
     */
    public Notification generate(final PendingIntent pendingIntent, final String title, @IntegerRes int resourceIcon, @Nullable final String message, @Nullable final String summaryText, boolean autocancel) {

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        if (message != null)
            bigText.bigText(message);
        bigText.setBigContentTitle(title);
        if (summaryText != null)
            bigText.setSummaryText(summaryText);
        Bitmap bigIcon = BitmapFactory.decodeResource(context.getResources(), resourceIcon);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(resourceIcon)
                        .setLargeIcon(bigIcon)
                        .setTicker(title)
                        .setStyle(bigText)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setAutoCancel(autocancel);

        if (pendingIntent != null)
            builder.setContentIntent(pendingIntent);
        if (message != null)
            builder.setContentText(message);
        return builder.build();

    }

    public static void show(int id, Notification notification) {
        notificationManager.notify(id, notification);
    }

    /***
     * Builder used to create our EasyNotification
     */
    public static class Builder {

        private Context mContext;

        /**
         * Set the Context used to instantiate the EasyNotification
         *
         * @param context the application context
         * @return the {@link com.} object.EasyGcm
         */
        public Builder context(final Context context) {
            mContext = context;
            return this;
        }

        /**
         * Initialize the SharedPreference instance to used in the application.
         *
         * @throws RuntimeException if Context has not been set.
         */
        public void build() {
            if (mContext == null) {
                throw new RuntimeException("Context not set, please set context");
            }


            EasyNotification.init(mContext);
        }
    }

}
