package com.example.studyapplication.glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.load.resource.bitmap.Rotate;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.example.studyapplication.R;

/**
 * 快速的网络加载图片
 */
public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        ImageView imageView = findViewById(R.id.glideimageview);

        //一   1.将网络图片加载进去    基本使用
//        Glide.with(this).load("").into(imageView);

//        //2.占位符
//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.placeholder(R.drawable.beauty1) //正在请求时显示图片
//                .error(R.drawable.beauty2)  //请求失败显示图片
//                .fallback(R.drawable.beauty3) //请求的url为null 显示的图片
//                .override(100,100);//图片大小
//        //将网络图片加载进去
//        Glide.with(this).load("").apply(requestOptions).into(imageView);

        //3.从占位图片到网络图片 交叉效果
        DrawableCrossFadeFactory fadeFactory = new DrawableCrossFadeFactory.Builder()
                .setCrossFadeEnabled(true).build();

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.beauty1) //正在请求时显示图片
                .error(R.drawable.beauty2)  //请求失败显示图片
                .fallback(R.drawable.beauty3) //请求的url为null 显示的图片
                .override(100,100);//图片大小
        //将网络图片加载进去
        Glide.with(this).load("").apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade(fadeFactory)).into(imageView);

        //4.变换
        Glide.with(this).load("").apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade(fadeFactory))
                .transform(new CircleCrop())  //圆角
                .transform(new RoundedCorners(30)) //四个角统一指定
                .transform(new GranularRoundedCorners(30,30,80,80)) //四个角单独指定
                .transform(new Rotate(90))//旋转
                .into(imageView);


        //二   需要先指定GlideMode  在build编译项目  可以减少创建请求类
//        GlideApp.with(this).load("").placeholder(R.drawable.beauty2).into(imageView);

        //当指定extension  和options注解时  可以直接使用和options注解的方法
        GlideApp.with(this).load("").defaultImag().into(imageView);
    }
}