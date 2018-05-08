package com.example.logindemo.model;

import com.example.logindemo.bean.LoginBean;
import com.example.logindemo.bean.RegBean;
import com.example.logindemo.http.OkHttpUtils;
import com.example.logindemo.http.OkLoadListener;
import com.google.gson.Gson;

import java.util.Map;

/**
 * author:Created by jiangkerun on 2018/5/8.
 */
public class LoginModel implements IModel {

    @Override
    public void getLoginDatas(String url, Map<String, String> map, final LoginListener loginListener) {
        OkHttpUtils httpUtils = OkHttpUtils.getHttpUtils ();

        httpUtils.okPost (url,map);

        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Gson gson = new Gson ();

                LoginBean loginBean = gson.fromJson (json, LoginBean.class);

                if(loginBean.getCode ().equals ("0")){
                    loginListener.loginSuccess (json);
                }else{
                    loginListener.loginError (json);
                }
            }

            @Override
            public void okLoadError(String error) {
                loginListener.loginError (error);
            }
        });
    }

    @Override
    public void getRegDatas(String url, Map<String, String> map, final RegListener regListener) {
        OkHttpUtils httpUtils = OkHttpUtils.getHttpUtils ();

        httpUtils.okPost (url,map);

        httpUtils.setOkLoadListener (new OkLoadListener () {
            @Override
            public void okLoadSuccess(String json) {
                Gson gson = new Gson ();

                RegBean regBean = gson.fromJson (json, RegBean.class);

                if(regBean.getCode ().equals ("0")){
                    regListener.regSuccess (json);
                }else{
                    regListener.regError (json);
                }
            }

            @Override
            public void okLoadError(String error) {
                regListener.regError (error);
            }
        });
    }
}
