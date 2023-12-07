package com.example.studyapplication.list;

import androidx.recyclerview.widget.RecyclerView;

public class Beauty {
    private int id;
    private  String name;

    public Beauty(){

    }

     public Beauty(int id,String name){
        this.id = id;
        this.name = name;
     }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
