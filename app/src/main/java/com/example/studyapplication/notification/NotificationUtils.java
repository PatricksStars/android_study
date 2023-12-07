package com.example.studyapplication.notification;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.example.studyapplication.R;

import java.io.File;

/**
 * 通知工具类需在AndroidManifest添加权限
 *     <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
 *
 *     设置震动权限添加<uses-permission android:name="android.permission.VIBRATE"/>
 */

public class NotificationUtils extends ContextWrapper {

    private Activity context;

    private NotificationManager notificationManager;

    private Notification notification;

    public NotificationUtils(Activity activity) {
        super(activity);
        context = activity;
    }

    public NotificationUtils(Activity activity,Class toClass,String channelId,String channelName,
                             String channelDescription,String contextTitle,String contextText,
                             int smallIcon,int largeIcon) {
        super(activity);
        context = activity;
        setPermission();
        createNotificationManager(channelId,channelName,channelDescription);
        createNotification(toClass,channelId,contextTitle,contextText,smallIcon,largeIcon);
    }

    //设置震动
    final long[] vibrationPattern = {100, 200, 300, 400}; // 设置震动模式，参数为一个 long 类型数组，表示震动的时长和间隔

    /**
     * 创建NotificationManager
     * @param channelId  通知渠道的标识符
     * @param channelName  通知渠道的位置
     * @param  channelDescription  通知渠道的描述
     */
    private void createNotificationManager(String channelId,String channelName,
                                           String channelDescription){
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // 创建通知渠道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelNameChar = channelName;    //
            //设置通知渠道的级别
//            IMPORTANCE_DEFAULT：（默认级别）
//            IMPORTANCE_HIGH：（高）
//            IMPORTANCE_LOW：（低）
//            IMPORTANCE_MAX：最重要的通知，系统会立马使得消息显示在屏幕
            int importance = NotificationManager.IMPORTANCE_HIGH;
            //创建通知渠道
            NotificationChannel notificationChannel = new NotificationChannel(
                    channelId, channelNameChar, importance);
            notificationChannel.setDescription(channelDescription);//可以省略
            // 配置通知出现时的震动（如果 Android 设备支持的话）
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(vibrationPattern);

            // 设置通知渠道的闪灯效果
            notificationChannel.enableLights(true); // 允许通知闪灯
            //在系统中注册消息
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    /**
     * 设置权限
     */
    private void setPermission(){
        //申请通知权限
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context,
                    new String[]{Manifest.permission.POST_NOTIFICATIONS},
                    PackageManager.VERIFICATION_ALLOW);
        }
    }

    /**
     * 创建通知必须设置小图标setSmallIcon   不然 程序会卡退
     */
    private void createNotification(Class toClass,String channelId,
                                    String contextTitle,String contextText,
                                    int smallIcon,int largeIcon){

        //点击通知后跳转页面
        Intent intent = new Intent(context,toClass);
        PendingIntent pi = PendingIntent.getActivity(context,
                PackageManager.PERMISSION_GRANTED, intent, PendingIntent.FLAG_IMMUTABLE);

        //创建通知
        notification = new NotificationCompat.Builder(context, channelId)
                .setContentTitle(contextTitle)    //消息的标题
                .setContentText(contextText)  //消息的内容
                .setSmallIcon(smallIcon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources()
                        ,largeIcon))
                .setWhen(System.currentTimeMillis())   //指定通知被创建的时间
                .setContentIntent(pi)   //点击后的跳转事件
                .setVibrate(vibrationPattern)  //设置震动
                .setLights(Color.RED,1000,2000)
                //.setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Big_Easy.ogg")))
                .setStyle(new NotificationCompat.BigTextStyle().bigText("text")) //富文本通知内容
                //显示大图
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.beauty3)))

                //通知的大图标
                .build();
    }

    /**
     * 通知
     * @param notifyId
     */
    public void notifys(int notifyId){
        notificationManager.notify(notifyId,notification);
    }

    /**
     * 通知
     * @param notifyId
     * @param notifications
     */
    public void notifys(int notifyId,Notification notifications){
        notificationManager.notify(notifyId,notifications);
    }


    /**
     * 显示取消  第二种设置在Builder.setAutoCancel(true)
     * @param notifyId
     */
    public void cancleNotifys(int notifyId){
        notificationManager.cancel(notifyId);
    }

}