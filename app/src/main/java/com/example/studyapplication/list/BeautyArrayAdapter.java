package com.example.studyapplication.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.studyapplication.R;

import java.util.List;

public class BeautyArrayAdapter extends ArrayAdapter<Beauty> {

    private int resourceId;
    public BeautyArrayAdapter(@NonNull Context context, int resource, @NonNull List<Beauty> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View coverView, ViewGroup parent){
        Beauty beauty = getItem(position);
        ViewHolder viewHolder;
        if(coverView == null){
            coverView = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = coverView.findViewById(R.id.imageview);
            viewHolder.textView = coverView.findViewById(R.id.textview);
            coverView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) coverView.getTag();
        }

        viewHolder.imageView.setImageResource(beauty.getId());
        viewHolder.textView.setText(beauty.getName());

        return coverView;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView textView;

    }
}
