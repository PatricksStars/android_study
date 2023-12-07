package com.example.studyapplication.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.studyapplication.EmptyActivity;
import com.example.studyapplication.R;
import com.example.studyapplication.baseattr.TitleActivity;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button button = findViewById(R.id.send);
        Button buttonCancle = findViewById(R.id.cancle);


        NotificationUtils notification = new NotificationUtils(
                NotificationActivity.this,
                EmptyActivity.class,
                "notification_id","古月方源","古月方源的消息",
                "消息标题","消息文本"
                ,R.drawable.beauty1,R.drawable.beauty2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notification.notifys(1);
            }
        });

        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                notification.cancleNotifys(1);
            }
        });


    }

}