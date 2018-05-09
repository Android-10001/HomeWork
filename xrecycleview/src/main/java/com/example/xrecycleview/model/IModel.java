package com.example.xrecycleview.model;

import java.util.Map;

/**
 * author:Created by jiangkerun on 2018/5/9.
 */
public interface IModel {
    void getData(String url, Map<String,String> map,ProductListener productListener);
}
