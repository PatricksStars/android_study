package com.example.studyapplication.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class FragmentPageAdapter extends FragmentStateAdapter {

    List<Fragment> list;

    public FragmentPageAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<Fragment> list){
        super(fragmentManager,lifecycle);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
