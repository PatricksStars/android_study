package com.example.studyapplication.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyapplication.R;

/**
 * 动态广播注册
 * * 这些敏感操作需要在androidmanifest.xml中配置
 *      *在application标签  同级添加标签
 *      *
 *      * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 *      * 表示允许网络   需要其他需要改name的内容
 */
public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        register();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(netWorkChangeReceiver);
    }

    private IntentFilter intentFilter;
    private NetWorkChangeReceiver netWorkChangeReceiver;

    private void register(){

        intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        netWorkChangeReceiver = new NetWorkChangeReceiver();
        registerReceiver(netWorkChangeReceiver,intentFilter);
    }

    /**
     * 这些敏感操作需要在androidmanifest.xml中配置
     *在application标签  同级添加标签
     *
     * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
     * 表示允许网络   需要其他需要改name的内容
     */
    class NetWorkChangeReceiver extends BroadcastReceiver {

        int i = 0;
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "网络变化", Toast.LENGTH_SHORT).show();

        }
    }
}