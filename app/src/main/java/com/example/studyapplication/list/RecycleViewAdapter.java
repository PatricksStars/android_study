package com.example.studyapplication.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyapplication.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {


    private List<Beauty> lists;

    private int layoutResId;

    private Context context;

    public RecycleViewAdapter(Context context,List<Beauty> lists,int layoutResId){
        this.lists = lists;
        this.layoutResId = layoutResId;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = View.inflate(context,layoutResId,parent);
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Beauty beauty = lists.get(position);
        holder.imageView.setImageResource(beauty.getId());
        holder.textView.setText(beauty.getName());
    }

    @Override
    public int getItemCount() {
        if(!lists.isEmpty() && lists != null){
            return lists.size();
        }
        return 0;
    }

    private OnRecycleItemListener onRecycleItemListener;
    public void setRecycleItemListener(OnRecycleItemListener onRecycleItemListener){
        this.onRecycleItemListener = onRecycleItemListener;
    }


    /**
     * 接受存放组件防止性能消耗
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onRecycleItemListener != null){
                        onRecycleItemListener.onRecycleItemClick(getBindingAdapterPosition());
                    }
                }
            });

            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
        }
    }

    public interface OnRecycleItemListener{
        void onRecycleItemClick(int position);
    }

}
