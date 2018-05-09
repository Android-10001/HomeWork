package com.example.xrecycleview.model;

import com.example.xrecycleview.bean.ProductBean;

/**
 * author:Created by jiangkerun on 2018/5/9.
 */
public interface ProductListener {
    void onSuccess(ProductBean productBean);

    void onError(String error);
}
