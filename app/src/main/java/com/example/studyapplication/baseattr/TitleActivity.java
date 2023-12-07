package com.example.studyapplication.baseattr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studyapplication.R;

/**
 * 标题导航栏的实现布局
 */
public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }
}