package com.example.logindemo.presenter;

import com.example.logindemo.model.IModel;
import com.example.logindemo.view.ILoginView;
import com.example.logindemo.view.IRegView;

/**
 * author:Created by jiangkerun on 2018/5/8.
 */
public interface IPresenter {
    void ShowLoginToView(IModel iModel, ILoginView iLoginView);

    void ShowRegToView(IModel iModel, IRegView iRegView);
}
