package com.example.studyapplication.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class SqliteCrud {
    public static void insert(SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","libai");
        contentValues.put("age",23);
        db.insert("Books",null,contentValues);
        contentValues.clear();
        contentValues.put("name","hanxin");
        contentValues.put("age",26);
        db.insert("Books",null,contentValues);
        contentValues.clear();
        contentValues.put("name","zhanli");
        contentValues.put("age",30);
        db.insert("Books",null,contentValues);
    }

    public static void update(SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put("age",1);
        db.update("Books",contentValues,"name=?",new String[]{"libai"});
    }

    public static void del(SQLiteDatabase db){
        db.delete("Books","name=?",new String[]{"zhanli"});
    }

    public static void query(SQLiteDatabase db, Context context){
           Cursor cursor =  db.query("Books",null,null,null,null,null,null);

           if(cursor.moveToFirst()){
               while(cursor.moveToNext()){
                   @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                   @SuppressLint("Range") float age = cursor.getFloat(cursor.getColumnIndex("age"));
                   Toast.makeText(context, name + "" + age, Toast.LENGTH_SHORT).show();
               }

           }
    }
}
