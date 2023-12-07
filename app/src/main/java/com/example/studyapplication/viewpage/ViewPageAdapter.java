package com.example.studyapplication.viewpage;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPageAdapter extends PagerAdapter {

    List<View> lists;

    public ViewPageAdapter(List<View> lists){
        this.lists = lists;
    }
    @Override
    public int getCount() {
        return (lists == null ? 0 : lists.size());
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(lists.get(position));
//        return super.instantiateItem(container, position);
        return lists.get(position);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(lists.get(position));
//        super.destroyItem(container, position, object);
    }
}
