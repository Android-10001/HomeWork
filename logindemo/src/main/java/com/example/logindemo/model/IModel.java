package com.example.logindemo.model;

import java.util.Map;

/**
 * author:Created by jiangkerun on 2018/5/8.
 */
interface IModel {
    void getLoginDatas(String url, Map<String,String> map, LoginListener loginListener);

    void getRegDatas(String url,Map<String,String> map,RegListener regListener);
}
