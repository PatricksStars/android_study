package com.example.studyapplication.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studyapplication.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据交换格式易于人编码解读
 */
public class GsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        //指定某些字段是否参加序列化反序列化时用这个创建    可以@expose注解控制
        Gson gsons = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        User user = new User("aa","bb","ccc");
        //常规都序列化反序列化  @expose注解控制不了否参加序列化反序列化
        Gson gson = new Gson();

        //序列化
        String json = gson.toJson(user);
        //反序列化
        User users = gson.fromJson(json, User.class);


        //解析集合  带有<User> 泛型时用TypeToken解析   不然反序列化lists.get(0).getName() 会报错
        List<User> list = new ArrayList<>();
        list.add(new User("aa","bb","ccc") );
        //序列化
        String jsons = gson.toJson(list);
        //反序列化
       Type type = new TypeToken<List<User>>(){}.getType();
        List<User> lists = gson.fromJson(jsons,type);

    }
}