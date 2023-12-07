package com.example.studyapplication.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Entity.class},version = 1,exportSchema = false)
public abstract class EntityDatabase extends RoomDatabase{

    public abstract EntityDao getEntityDao();

    public static EntityDatabase instance;
    public static EntityDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),EntityDatabase.class,"entity_db")
//                    .allowMainThreadQueries()//仅限测试用   开发不能用   强制开启主线程
                    .build();
        }
        return instance;
    }
}
