package com.hirdesh.notificationexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "Message Channel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQ_CODE = 100;

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.anime, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
        assert bitmapDrawable != null;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        Notification notification;
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent inotify = new Intent(getApplicationContext(), MainActivity.class);
        inotify.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_CODE, inotify, PendingIntent.FLAG_MUTABLE);

        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) Objects.requireNonNull(ResourcesCompat.getDrawable(getResources(), R.drawable.anime, null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image Sent by Hirdesh")
                .setSummaryText("Image Message");

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .setBigContentTitle("Message from Raman")
                .setSummaryText("Message");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.anime)
                    .setContentTitle("New Message")
                    .setSubText("New Message from Someone")
                    .setChannelId(CHANNEL_ID)
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setOngoing(false)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH));
        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.anime)
                    .setContentTitle("New Message")
                    .setSubText("New Message from Someone")
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setOngoing(false)
                    .build();
        }

        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
