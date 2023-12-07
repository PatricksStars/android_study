package com.example.studyapplication.popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.studyapplication.R;

public class PopupwindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);

        Button button = findViewById(R.id.popup);
        Button buttondown = findViewById(R.id.popdown);

        View view = getLayoutInflater().inflate(R.layout.activity_notification,null);

        PopupWindow popupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.showAsDropDown(view);
            }
        });

        buttondown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
    }
}