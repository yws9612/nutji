package org.techtown.dontlate.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import org.techtown.dontlate.R;
import org.techtown.dontlate.activities.RingActivity;

import static org.techtown.dontlate.application.App.CHANNEL_ID;
import static org.techtown.dontlate.broadcastreceiver.AlarmBroadcastReceiver.TITLE;


public class AlarmService extends Service {

    private Vibrator vibrator;

    @Override
    public void onCreate() {
        super.onCreate();

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notificationIntent = new Intent(this, RingActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        String alarmTitle = String.format("%s", intent.getStringExtra(TITLE));

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(alarmTitle)
                .setContentText("알람이 울립니다.")
                .setSmallIcon(R.drawable.ic_alarm_black_24dp)
                .setContentIntent(pendingIntent)
                .build();



        long[] pattern = { 0, 100, 1000 };
        vibrator.vibrate(pattern, 0);

        startForeground(1, notification);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        vibrator.cancel();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
