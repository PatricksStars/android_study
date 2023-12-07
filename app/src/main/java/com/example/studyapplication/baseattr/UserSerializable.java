package com.example.studyapplication.baseattr;

import java.io.Serializable;

public class UserSerializable implements Serializable {

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

    public UserSerializable(int _id, String name, String password) {
        this._id = _id;
        this.name = name;
        this.password = password;
    }
}
