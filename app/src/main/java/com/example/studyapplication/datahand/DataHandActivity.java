package com.example.studyapplication.datahand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.studyapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 数据操作  io流读写， SharedPreferences.Editor 键值对存储
 */
public class DataHandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_hand);

    }

    private void writePre(){
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("name","libai");
        editor.putInt("age",3);
        editor.apply();
    }

    private void readPre(){
        SharedPreferences read = getSharedPreferences("data",MODE_PRIVATE);
        String name = read.getString("name","");
        int age = read.getInt("age",0);
    }


    /**
     * io流写操作
     * @param text
     */
    private void write(String text){
        FileOutputStream os = null;
        BufferedWriter writer = null;
        try {
            os = openFileOutput("data",MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write(text);
        }catch (Exception e){

        }finally {
            try {
                writer.close();
                os.close();
            }catch (Exception e){

            }

        }
    }

    /**
     * io流读操作
     * @return
     */
    private String read(){
        FileInputStream is = null;
        BufferedReader reader = null;
        try {
            is = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(is));
            String text = "";
            String line = "";
            while((line = reader.readLine()) != null){
                text += line;
            }
            return text;
        }catch (Exception e){

        }finally {
            try {
                reader.close();
                is.close();
            }catch (Exception e){

            }
        }
        return "";
    }
}