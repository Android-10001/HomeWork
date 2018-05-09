package com.example.xrecycleview.presenter;

import com.example.xrecycleview.bean.ProductBean;
import com.example.xrecycleview.http.Urls;
import com.example.xrecycleview.model.IModel;
import com.example.xrecycleview.model.ProductListener;
import com.example.xrecycleview.model.ProductModel;
import com.example.xrecycleview.view.IView;

import java.util.HashMap;
import java.util.Map;

/**
 * author:Created by jiangkerun on 2018/5/9.
 */
public class ProductPresenter implements IPresenter{
    private final ProductModel productModel;
    private IView iView;

    public ProductPresenter(IView iView){
        this.iView=iView;
        productModel = new ProductModel();
    }
    @Override
    public void ShowProductToView(String page) {
        Map<String,String> map=new HashMap<>();
        map.put("pscid","1");
        map.put("page",page);
        productModel.getData(Urls.productUrl, map, new ProductListener() {
            @Override
            public void onSuccess(ProductBean productBean) {
                iView.showSuccess(productBean);
            }

            @Override
            public void onError(String error) {
                iView.showError(error);
            }
        });
    }
    public void unBind(){
        if (iView!=null){
            iView=null;
        }
    }
}
