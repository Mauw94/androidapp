package com.example.maurits.universo.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import com.example.maurits.universo.notifications.NotificationHelper;

import java.util.Random;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by niels on 24-Oct-17.
 */

public class AlarmNotificationReciever extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationHelper helper;
        helper = new NotificationHelper(context);
        NotificationCompat.Builder builder = helper.getNotification("Universo","Discover the universe with Universo");
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(1,builder.build());
    }
}