package com.example.studyapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studyapplication.R;

/**
 * 静态添加只需要在指定的xml中 添加
 * <fragment
 *     android:id="@+id/frag"
 *     android:layout_width="wrap_content"
 *     android:layout_height="wrap_content"
 *     android:layout_weight="1"
 *     android:name="com.example.studyapplication.fragment.FragmentActivity"/>
 *     属性引用即可
 */
public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment2,container,false);
        return view;
    }
}