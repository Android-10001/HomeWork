package com.example.retrofit.utils;

import com.example.retrofit.bean.MyBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:Created by jiangkerun on 2018/5/11.
 */
public interface ApiService {
    @GET("ad/getAd")
    Call<MyBean> doGet(@Query("num")int num);
}
