package com.example.studyapplication.rx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class CustomObserver implements Observer<String> {
    public abstract void sucess(String text);
    public abstract void error(String message);

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull String s) {
        if(s.equals("成功")){
            sucess(s);
        }else{
            error("错误失败");
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
