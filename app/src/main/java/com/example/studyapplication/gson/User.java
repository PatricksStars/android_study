package com.example.studyapplication.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @Expose
    private String id;
    @Expose
    private String name;

    //      是否参加序列化      是否参加反序列化
    @Expose(serialize = true,deserialize = false)
    private String age;

    /**
     * 用于序列化  关键字
     */
    @SerializedName("class")
    private String clz;

    public User(String id ,String name ,String age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
