package com.example.maurits.universo.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.maurits.universo.R;
import com.example.maurits.universo.activity.MainActivity;
import com.example.maurits.universo.activity.StartUpActivity;

/**
 * Created by niels on 24-Oct-17.
 */

public class NotificationHelper extends ContextWrapper {
    private static final String UNIVERSO_CHANNEL_ID = "com.example.universo";
    private static final String UNIVERSO_CHANNEL_NAME = "universo Channel";
    private NotificationManager manager;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel nielschannel = new NotificationChannel(UNIVERSO_CHANNEL_ID, UNIVERSO_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        nielschannel.enableLights(true);
        nielschannel.enableVibration(true);
        nielschannel.setLightColor(Color.GREEN);
        nielschannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(nielschannel);
    }

    public NotificationManager getManager() {
        if (manager == null)
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getNotification(String title, String text) {
        Notification.Builder builder = new Notification.Builder(getApplicationContext(), UNIVERSO_CHANNEL_ID);
        builder.setContentTitle(title);
        builder.setContentText(text);
        builder.setSmallIcon(R.drawable.universeicon);
        builder.setAutoCancel(true);
        //builder.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;

        Intent resultIntent = new Intent(this, StartUpActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,0,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);
        return builder;
    }
}
