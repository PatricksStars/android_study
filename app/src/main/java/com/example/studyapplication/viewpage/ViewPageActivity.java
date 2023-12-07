package com.example.studyapplication.viewpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.studyapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);

        ViewPager viewPager = findViewById(R.id.viewpage);

        LayoutInflater layoutInflater =  LayoutInflater.from(this);
        View view1= layoutInflater.inflate(R.layout.activity_fragment,null);
        View view2= layoutInflater.inflate(R.layout.activity_fragment2,null);
        View view3= layoutInflater.inflate(R.layout.activity_fragment3,null);
        List<View> list = new ArrayList<>();
        list.add(view1);
        list.add(view2);
        list.add(view3);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(list) ;
        viewPager.setAdapter(viewPageAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}