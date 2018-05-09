package com.example.xrecycleview.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.xrecycleview.R;
import com.example.xrecycleview.adapter.MyAdapter;
import com.example.xrecycleview.bean.ProductBean;
import com.example.xrecycleview.presenter.ProductPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {
    private XRecyclerView xrecy;
    private ProductPresenter productPresenter;
    private  List<ProductBean.DataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        xrecy =findViewById(R.id.xrecy);
        //上拉刷新
        xrecy.setPullRefreshEnabled(true);
        //下拉加载
        xrecy.setLoadingMoreEnabled(true);
        productPresenter = new ProductPresenter(this);
        //创建布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        xrecy.setLayoutManager(manager);
        //设置监听
        xrecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                page=1;
                productPresenter.ShowProductToView(page+"");
                xrecy.refreshComplete();
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                page++;
                productPresenter.ShowProductToView(page+"");
                xrecy.refreshComplete();
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showSuccess(ProductBean productBean) {
        List<ProductBean.DataBean> data = productBean.getData();
       list.addAll(data);
        myAdapter = new MyAdapter(this, list);
        xrecy.setAdapter(myAdapter);
        myAdapter.setSetonItem(new MyAdapter.SetonItem() {
            @Override
            public void onItemLinister(int postion, int pid, View view) {
                Toast.makeText(MainActivity.this, pid, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void showError(String error) {
        Log.e("QQQQQ",error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (productPresenter!=null){
            productPresenter.unBind();
        }
    }
}
