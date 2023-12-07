package com.example.studyapplication.animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studyapplication.R;

public class AnimationActivity extends AppCompatActivity {
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f,1f);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
//                float value = (float) valueAnimator.getAnimatedValue();
//            }
//        });
//        valueAnimator.start();

        TextView textView = findViewById(R.id.animtext);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"alpha",0f,1f);
        objectAnimator.setDuration(4000);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
            }
        });
        objectAnimator.start();


//补间动画
        ImageView imageView = findViewById(R.id.animimage);
        //模糊程度
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        //旋转
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        //缩放
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.scale);
        //平移
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.translate);
        animation.setDuration(1000);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(animation);
            }
        });

                //1.   动态动画
//        LinearLayout linearLayout = findViewById(R.id.listliner);
//        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
//
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(flag){
//                    animationDrawable.start();
//                    flag = false;
//                }else{
//                    animationDrawable.stop();
//                    flag = true;
//                }
//            }
//        });
    }
}