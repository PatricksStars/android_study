package com.example.studyapplication.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyapplication.R;
import com.example.studyapplication.broadcast.BroadcastActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.delActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(offlineReceiver != null){
            unregisterReceiver(offlineReceiver);
            offlineReceiver = null;
        }
    }

    private IntentFilter intentFilter;
    private OfflineReceiver offlineReceiver;
    private void register(){

        intentFilter = new IntentFilter();
        intentFilter.addAction("ForcedDownline");
        offlineReceiver = new OfflineReceiver();
        registerReceiver(offlineReceiver,intentFilter);
    }


    class OfflineReceiver extends BroadcastReceiver {

        int i = 0;
        @Override
        public void onReceive(Context context, Intent intent) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setTitle("标题");
            dialog.setMessage("信息");
            dialog.setCancelable(false);
            dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(context, "下线", Toast.LENGTH_SHORT).show();
                    ActivityController.finishAll();
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }
            });
            dialog.show();


        }
    }
}
