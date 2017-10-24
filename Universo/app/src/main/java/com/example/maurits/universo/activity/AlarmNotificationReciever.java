package com.example.maurits.universo.activity;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Random;

/**
 * Created by niels on 24-Oct-17.
 */

public class AlarmNotificationReciever extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationHelper helper;
        helper = new NotificationHelper(context);
        Notification.Builder builder = helper.getNotification();
        helper.getManager().notify(new Random().nextInt(),builder.build());
    }
}