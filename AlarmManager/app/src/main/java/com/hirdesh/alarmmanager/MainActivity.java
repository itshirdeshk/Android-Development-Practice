package com.hirdesh.alarmmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        edtTime = findViewById(R.id.edtTime);

        findViewById(R.id.btnSet).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.S)
            @Override
            public void onClick(View view) {
                int time = Integer.parseInt(((EditText)(findViewById(R.id.edtTime))).getText().toString());
                long triggerTime = System.currentTimeMillis() + ((long) time * 1000);

                Intent iBroadCast = new Intent(MainActivity.this, MyReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 100, iBroadCast, PendingIntent.FLAG_MUTABLE);

                alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);

            }
        });
    }
}