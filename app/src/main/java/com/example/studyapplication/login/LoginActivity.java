package com.example.studyapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studyapplication.EmptyActivity;
import com.example.studyapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button button = findViewById(R.id.loginbuttton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if("admin".equals(user) && "admin".equals(pass)){

//                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                    startActivity(intent);
//                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "账号密码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}