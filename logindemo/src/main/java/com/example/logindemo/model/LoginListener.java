package com.example.logindemo.model;

/**
 * author:Created by jiangkerun on 2018/5/8.
 */
public interface LoginListener {
    void loginSuccess(String json);

    void loginError(String error);
}
