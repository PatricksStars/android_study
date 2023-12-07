package com.example.studyapplication.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.studyapplication.EmptyActivity;
import com.example.studyapplication.R;

public class SQliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        SqLiteUtil sqLiteUtil = new SqLiteUtil(this, "bookstore.dp", null, 3);
        Button addbutton = findViewById(R.id.addbutton);
        Button upbutton = findViewById(R.id.upbutton);
        Button delbutton = findViewById(R.id.delbutton);
        Button qubutton = findViewById(R.id.qubutton);
        SQLiteDatabase db = sqLiteUtil.getWritableDatabase();
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SqliteCrud.insert(db);
            }
        });
        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SqliteCrud.update(db);
            }
        });
        delbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SqliteCrud.del(db);
            }
        });
        qubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SqliteCrud.query(db, SQliteActivity.this);
            }
        });
    }

}