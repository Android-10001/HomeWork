package com.example.xrecycleview.http;

/**
 * author:Created by jiangkerun on 2018/5/8.
 */
public interface OkLoadListener {
    void okLoadSuccess(String json);

    void okLoadError(String error);
}
