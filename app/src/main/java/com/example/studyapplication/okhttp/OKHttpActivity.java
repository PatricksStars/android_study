package com.example.studyapplication.okhttp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.studyapplication.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * android4.4 以后由 httpurlconnection 变成okhttp
 */
public class OKHttpActivity extends AppCompatActivity {

    private OkHttpClient okHttpClient;
    List<Cookie> lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        okHttpClient = new OkHttpClient();


        //添加缓存
        okHttpClient = new OkHttpClient.Builder()
                .cache(new Cache(new File(("")),1024*1024))

                .build();
        //添加缓存
        okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(@NonNull HttpUrl httpUrl, @NonNull List<Cookie> list) {
                        lists = list;
                    }

                    @NonNull
                    @Override
                    public List<Cookie> loadForRequest(@NonNull HttpUrl httpUrl) {

                        //todo
                        if(httpUrl.host().equals("www.baidu.com")){
                            return lists;
                        }
                        return null;
                    }
                })
                .build();



        //添加拦截器
        okHttpClient =  new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @NonNull
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                //todo
                Request request = chain.request().newBuilder().addHeader("os","android")
                        .addHeader("version","1.0").build();


                Response response = chain.proceed(request);  //(chain.request());

                //todo
                return response;
            }

            // 按照先后顺序执行
        }).addInterceptor(new Interceptor() {
            @NonNull
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                String os = chain.request().header("os");

                return chain.proceed(chain.request());
            }
        })
                .build();
    }

    public void uploadFile(){
        File file = new File("");
        MultipartBody body =  new MultipartBody.Builder().addFormDataPart("filename",file.getName(),
                RequestBody.create(file, MediaType.parse("text/plain"))).build();

        Request request = new Request.Builder().url("")
                .post(body).build();

        Call call = okHttpClient.newCall(request);
    }

    public void uploadJson(){
       RequestBody requestBody = RequestBody.create("{\"a\":\"zhi\"}",
               MediaType.parse("application/json"));

        Request request = new Request.Builder().url("")
                .post(requestBody).build();

        Call call = okHttpClient.newCall(request);
    }



    /**
     * 同步请求代码
     * @param view
     */
    public void getSync(View view){
        new Thread(){
            @Override
            public void run() {
                Request request = new Request.Builder().url("").build();

                Call call = okHttpClient.newCall(request);

                try {
                    Response response = call.execute();
                    String message = response.body().string();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();


    }

    /**
     * 异步请求
     * @param view
     */
    public void getASync(View view){
        Request request = new Request.Builder().url("").build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){

                }
            }
        });
    }

    /**
     * post同步请求
     * @param view
     */
    public void postSync(View view){
        new Thread(){
            @Override
            public void run() {
                FormBody formBody = new FormBody.Builder()
                        .add("a","").add("b","").build();
                Request request = new Request.Builder().url("")
                        .post(formBody).build();

                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    String message = response.body().string();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();


    }

    public void postASync(View view){
        FormBody formBody = new FormBody.Builder()
                .add("a","").add("b","").build();
        Request request = new Request.Builder().url("")
                .post(formBody).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.isSuccessful()){

                }
            }
        });
    }
}