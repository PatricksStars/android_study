package com.example.studyapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 静态广播在androidmanifest.xml配置
 * <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
 *
 * application标签里添加
 * <receiver
 *             android:name=".broadcast.StaticBroadcastReceiver"
 *             android:enabled="true"
 *             android:exported="true">
 *             <intent-filter>
 *                 <action android:name="android.intent.action.BOOT_COMPLETED" />
 *             </intent-filter>
 *         </receiver>
 */
public class StaticBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//        // TODO: This method is called when the BroadcastReceiver is receiving
//        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context,"完成",Toast.LENGTH_SHORT).show();
    }
}