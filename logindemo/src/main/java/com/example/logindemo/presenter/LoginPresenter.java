package com.example.logindemo.presenter;

import com.example.logindemo.http.Urls;
import com.example.logindemo.model.IModel;
import com.example.logindemo.model.LoginListener;
import com.example.logindemo.model.RegListener;
import com.example.logindemo.view.ILoginView;
import com.example.logindemo.view.IRegView;

import java.util.HashMap;
import java.util.Map;

/**
 * author:Created by jiangkerun on 2018/5/8.
 */
public class LoginPresenter implements IPresenter {
    @Override
    public void ShowLoginToView(IModel iModel, final ILoginView iLoginView) {
        Map<String,String> map = new HashMap<> ();

        map.put ("mobile",iLoginView.getMobile ());

        map.put ("password",iLoginView.getPwd ());

        iModel.getLoginDatas (Urls.loginUrl, map, new LoginListener() {
            @Override
            public void loginSuccess(String json) {
                iLoginView.showSuccess ();
            }

            @Override
            public void loginError(String error) {
                iLoginView.showError ();
            }
        });
    }

    @Override
    public void ShowRegToView(IModel iModel, final IRegView iRegView) {
        Map<String,String> map = new HashMap<>();

        map.put ("mobile",iRegView.getMobile ());

        map.put ("password",iRegView.getPwd ());

        iModel.getRegDatas (Urls.regUrl, map, new RegListener() {
            @Override
            public void regSuccess(String json) {
                iRegView.showSuccess ();
            }

            @Override
            public void regError(String error) {
                iRegView.showError ();
            }
        });
    }
}
