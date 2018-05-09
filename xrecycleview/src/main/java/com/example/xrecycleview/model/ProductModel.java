package com.example.xrecycleview.model;

import com.example.xrecycleview.bean.ProductBean;
import com.example.xrecycleview.http.OkHttpUtils;
import com.example.xrecycleview.http.OkLoadListener;
import com.google.gson.Gson;

import java.util.Map;

/**
 * author:Created by jiangkerun on 2018/5/9.
 */
public class ProductModel implements IModel{

    @Override
    public void getData(String url, Map<String, String> map, final ProductListener productListener) {
        OkHttpUtils okHttpUtils = OkHttpUtils.getHttpUtils();
        okHttpUtils.okPost(url,map);
        okHttpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Gson gson = new Gson();
                ProductBean productBean = gson.fromJson(json, ProductBean.class);
                if (productBean.getCode().equals("0")){
                    productListener.onSuccess(productBean);
                }else{
                    productListener.onError(json);
                }
            }

            @Override
            public void okLoadError(String error) {
                    productListener.onError(error);
            }
        });
    }

}
