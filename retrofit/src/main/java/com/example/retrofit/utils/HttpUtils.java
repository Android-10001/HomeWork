package com.example.retrofit.utils;

import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by jiangkerun on 2018/5/11.
 */
public class HttpUtils {

    private static HttpUtils instance;
    private final Retrofit retrofit;

    public HttpUtils(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        File file = new File(Environment.getExternalStorageDirectory(),"cache11111");

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.readTimeout(3000, TimeUnit.SECONDS);
        okHttpClient.connectTimeout(3000,TimeUnit.SECONDS);
        okHttpClient.cache(new Cache(file,10*1024));
        okHttpClient.addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY));
        okHttpClient.addNetworkInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY));

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn/")
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static HttpUtils getInstance(){
        if(instance==null){
            synchronized (HttpUtils.class){
                if(null==instance){
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    public ApiService getApi(){
        return retrofit.create(ApiService.class);
    }
}
