package com.example.xrecycleview.view;

import com.example.xrecycleview.bean.ProductBean;

/**
 * author:Created by jiangkerun on 2018/5/9.
 */
public interface IView {
    void showSuccess(ProductBean productBean);

    void showError(String error);

}
