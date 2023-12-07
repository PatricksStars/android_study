package com.example.studyapplication.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SqLiteUtil extends SQLiteOpenHelper {

    private Context context;
    private static final String createTable = "create table Books" +
            "(id integer primary key autoincrement,name text,age real)";



    private static final String createTable2 = "create table Stores" +
            "(id integer primary key autoincrement,name text,age real)";
    public SqLiteUtil(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //当创建已经存在的表时会创建失败   后续代码也不会执行  需要在onUpgrade升级  并且初始化类时版本号要升级
        sqLiteDatabase.execSQL(createTable);
        sqLiteDatabase.execSQL(createTable2);
        Toast.makeText(context,"成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Books");
        sqLiteDatabase.execSQL("drop table if exists Stores");
        onCreate(sqLiteDatabase);
    }
}
