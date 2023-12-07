package com.example.studyapplication.rx;

import io.reactivex.rxjava3.core.Observable;

public class LoginEngine {

    public static Observable<String> login(String name,String password){
        String text;
        if(name.equals("admin")){
            text = "成功" ;
        }else{
            text = "失败";
        }
        return Observable.just(text);
    }
}
