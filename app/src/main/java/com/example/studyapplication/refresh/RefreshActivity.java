package com.example.studyapplication.refresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.studyapplication.R;
import com.scwang.smart.refresh.footer.BallPulseFooter;
import com.scwang.smart.refresh.header.BezierRadarHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class RefreshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);

        ListView listView = findViewById(R.id.leftlistview);

        //ArrayAdapter
        List<String> lists = new ArrayList<>();
//        String[] lists = new String[100];
//        lists = new String[]{"AAAA","BBBB","CCCC","DDDD","EEEE"};
        lists.add("AAAA") ;
        lists.add("BBBB") ;
        lists.add("CCCC") ;
        lists.add("DDDD") ;
        lists.add("EEEE") ;

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                lists);

        SmartRefreshLayout smartRefreshLayout = findViewById(R.id.leftrefresh);
        //设置头部刷新的样式
        smartRefreshLayout.setRefreshHeader(new BezierRadarHeader(this));
        //设置页脚刷新的样式
        smartRefreshLayout.setRefreshFooter(new BallPulseFooter(this));
        //设置头部刷新时间监听
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

                smartRefreshLayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
                //添加一条新数据，再最开头的位置

                lists.add("QQQQ") ;
                lists.add("WWWW") ;
                lists.add("EEEE") ;
                lists.add("RRRR") ;
                lists.add("TTTT") ;
                arrayAdapter.notifyDataSetChanged();

                Toast.makeText(RefreshActivity.this, "刷新成功上", Toast.LENGTH_SHORT).show();
            }
        });

        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

                smartRefreshLayout.finishLoadMore(2000);
                //添加一条新数据，再最后的位置
                lists.add("AAAA") ;
                lists.add("SSSS") ;
                lists.add("DDDD") ;
                lists.add("FFFF") ;
                lists.add("GGGG") ;
                arrayAdapter.notifyDataSetChanged();

                Toast.makeText(RefreshActivity.this, "刷新成功下", Toast.LENGTH_SHORT).show();
            }
        });


//        //自定义ArrayAdapter
//        List<CustomClass> list = new ArrayList<>();
//        list.add(new CustomClass(R.drawable.beauty1,"beauty1"));
//        list.add(new CustomClass(R.drawable.beauty2,"beauty2"));
//        list.add(new CustomClass(R.drawable.beauty3,"beauty3"));
//        list.add(new CustomClass(R.drawable.beauty4,"beauty4"));
//        list.add(new CustomClass(R.drawable.beauty5,"beauty5"));
//        CustomList customList = new CustomList(views.getContext(),R.layout.customlist,list);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                CustomClass customClass = list.get(i);
                Toast.makeText(RefreshActivity.this,lists.get(i),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}