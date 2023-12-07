package com.example.studyapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EntityDao {

    @Insert
    public void insert(Entity ... entity);

    @Insert
    public  void insertAll(Entity ... entities);

    @Delete
    public void del(Entity ... entity);

    @Query("delete from Entity")
    public void delAll();

    @Update
    public void update(Entity ... entity);

    @Query("select * from Entity")
    public List<Entity> query(Entity entity);


}
