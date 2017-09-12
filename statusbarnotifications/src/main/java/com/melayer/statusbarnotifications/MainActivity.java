package com.melayer.statusbarnotifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNotification(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String id = "my_channel_01";
            CharSequence name = "Chanel Name";
            String description = "Description";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(id, name, importance);
            mChannel.setDescription(description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            manager.createNotificationChannel(mChannel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, id);

            builder.setOngoing(true)
                    .setContentText("Content Text")
                    //.setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentInfo("Content Info")
                    .setContentTitle("Content Title")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(PendingIntent.getActivity(
                            this,
                            1456,
                            new Intent(this, SampleActivity.class),
                            PendingIntent.FLAG_UPDATE_CURRENT
                            )
                    );

            manager.notify(123, builder.build());
        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "123");

            builder.setOngoing(true)
                    .setContentText("Content Text")
                    //.setAutoCancel(true)
                    .setWhen(System.currentTimeMillis())
                    .setContentInfo("Content Info")
                    .setContentTitle("Content Title")
                    .setSmallIcon(R.mipmap.ic_launcher);

            manager.notify(123, builder.build());
        }
    }
}
