package com.example.studyapplication.rx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studyapplication.R;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;


/**
 * 响应式编程
 */
public class RxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        //响应式从起点到终点 上一层的参数和传递给下一层的参数类型对应
        //Observer的泛型string是根据just里的参数类型来的
        //just起点 第二步
        Observable.just("").subscribe(new Observer<String>() {
            //第一步
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }
            //第三步
            @Override
            public void onNext(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
            //第四步
            @Override
            public void onComplete() {

            }
        });

        //just起点 第二步
        Observable.just("")

                //第三步   所有map 依次顺序执行
                .map(new Function<String, Object>() {

                    @Override
                    public Object apply(String s) throws Throwable {

                        return null;
                    }
                })
                .map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) throws Throwable {
                        return null;
                    }
                })
                //
                .subscribe(new Observer<Object>() {
                    //第一步
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                    //第四步
                    @Override
                    public void onNext(@NonNull Object o) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                    //第五步
                    @Override
                    public void onComplete() {

                    }
                });


        String[] strs = {"aa","bb","cc"};
        for(String str : strs){

        }

        //打印效果
        Observable.fromArray(strs).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {

            }
        });

        //自定义
        LoginEngine.login("","").subscribe(new CustomObserver() {
            @Override
            public void sucess(String text) {

            }

            @Override
            public void error(String message) {

            }
        });
    }
}