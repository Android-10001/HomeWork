package com.example.logindemo.model;

/**
 * author:Created by jiangkerun on 2018/5/8.
 */
public interface RegListener {
    void regSuccess(String json);

    void regError(String error);
}
