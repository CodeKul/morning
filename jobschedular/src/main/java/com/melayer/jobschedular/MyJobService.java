package com.melayer.jobschedular;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by aniruddha on 30/8/17.
 */

public class MyJobService extends JobService {

    private MediaPlayer mp;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        Log.i("@codekul", "Started Job");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "123");

        builder.setTicker("Song Service")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentText("Content")
                .setOngoing(true)
                .setAutoCancel(false)
                .setDefaults(Notification.DEFAULT_ALL)
                .setChannelId("123");

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //manager.notify(123, builder.build());
        startForeground(123, builder.build());

        mp = MediaPlayer.create(this, R.raw.my);
        mp.start();

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
      /*  mp.stop();
        mp.release();*/
        return false;
    }
}
