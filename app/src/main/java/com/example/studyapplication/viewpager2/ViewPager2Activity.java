package com.example.studyapplication.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.studyapplication.R;
import com.example.studyapplication.fragment.Fragment2;

import java.util.ArrayList;
import java.util.List;

public class ViewPager2Activity extends AppCompatActivity {
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        viewPager = findViewById(R.id.mainviewpager);
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment());
        list.add(new Fragment2());
        list.add(new Fragment());
        list.add(new Fragment2());
        FragmentPageAdapter fragmentPageAdapter = new FragmentPageAdapter(getSupportFragmentManager(),
                getLifecycle(),list);
        viewPager.setAdapter(fragmentPageAdapter);

        //跳转第二页
        viewPager.setCurrentItem(2);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });

    }
}