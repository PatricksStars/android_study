package com.example.studyapplication.baseattr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.studyapplication.R;

/**
 * intent接收数据实现
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



    }

    /**
     * 获取intnet数据
     */
    public void getIntnetData(){
        Intent intent = getIntent();
        String text = intent.getStringExtra("data");
        //已经拆开bundle了
        String aa = intent.getStringExtra("aa");

        UserSerializable user = (UserSerializable) intent.getSerializableExtra("user");

        UserParcelable userParcelable = intent.getParcelableExtra("userquick");

        Toast.makeText(SecondActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}