package com.example.studyapplication.glide;

import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.request.BaseRequestOptions;
import com.example.studyapplication.R;

/**
 * 扩展注解
 */
@com.bumptech.glide.annotation.GlideExtension
public class GlideExtension {
    private GlideExtension(){

    }

    @GlideOption
    public static BaseRequestOptions<?> defaultImag(BaseRequestOptions<?> options){
        return options.placeholder(R.drawable.beauty1) //正在请求时显示图片
                .error(R.drawable.beauty2)  //请求失败显示图片
                .fallback(R.drawable.beauty3) //请求的url为null 显示的图片
                .override(100,100);//图片大小
    }
}
