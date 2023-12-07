package com.example.studyapplication.room;

import androidx.room.PrimaryKey;

/**
 * 表 按表名称来写类名
 *
 * id字段用 _id规范
 */
@androidx.room.Entity
public class Entity {
    @PrimaryKey(autoGenerate = true)
    private int _id;

    private String name;

    private String password;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Entity(int _id, String name, String password) {
        this._id = _id;
        this.name = name;
        this.password = password;
    }
}
