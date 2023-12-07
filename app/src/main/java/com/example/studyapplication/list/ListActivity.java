package com.example.studyapplication.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.studyapplication.EmptyActivity;
import com.example.studyapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * listview,以及自定义arrayadapter
 */
public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);




    }

    private List<Beauty> list = new ArrayList<>();

    public void initList(){
        Beauty a = new Beauty(R.drawable.beauty1,"aaaa");
        Beauty b = new Beauty(R.drawable.beauty2,"baaa");
        Beauty c = new Beauty(R.drawable.beauty3,"caaa");
        Beauty d = new Beauty(R.drawable.beauty4,"daaa");
        Beauty e = new Beauty(R.drawable.beauty5,"eaaa");
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
    }
    public void setRecycleView(){
        initList();
        RecycleViewAdapter recycleViewAdapter =
                new RecycleViewAdapter(this,list,R.layout.beauty);
        recycleViewAdapter.setRecycleItemListener(new RecycleViewAdapter.OnRecycleItemListener() {
            @Override
            public void onRecycleItemClick(int position) {
                Beauty beauty = list.get(position);
                Toast.makeText(ListActivity.this, beauty.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recycleViewAdapter);



    }
    public void setListView2(){
        initList();
//        BeautyArrayAdapter beautyArrayAdapter =
//                new BeautyArrayAdapter(this,R.layout.beauty,list);
//
//        ListView listView = findViewById(R.id.listview);
//        listView.setAdapter(beautyArrayAdapter);
//
//        //点击事件
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Beauty beauty = list.get(i);
//                Toast.makeText(ListActivity.this, beauty.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }



    private String[] lists = {"a","b","c","d","e"};
    public void setListView1(){
//        ArrayAdapter<String> arrayAdapter =
//                new ArrayAdapter<>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,lists);
//
//        ListView listView = findViewById(R.id.listview);
//        listView.setAdapter(arrayAdapter);
    }
}