package com.melayer.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class SimpleService extends Service {

    private MediaPlayer mp;

    public SimpleService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mp = MediaPlayer.create(this, R.raw.my);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp.start();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "123");

        builder.setTicker("Song Service")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentText("Content")
                .setOngoing(true)
                .setAutoCancel(false)
                .setDefaults(Notification.DEFAULT_ALL)
                .setChannelId("123");

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        manager.notify(123, builder.build());
        startForeground(123, builder.build());

        return START_STICKY_COMPATIBILITY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }
}
