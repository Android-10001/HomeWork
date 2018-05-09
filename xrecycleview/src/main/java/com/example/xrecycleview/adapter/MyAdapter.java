package com.example.xrecycleview.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xrecycleview.R;
import com.example.xrecycleview.bean.ProductBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * author:Created by jiangkerun on 2018/5/9.
 */
public class MyAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder>{
    private static final int TYPE0 = 0;
    private static final int TYPE1 = 1;
    private Context context;
    List<ProductBean.DataBean> list;
    public MyAdapter(Context context, List<ProductBean.DataBean> list) {
        this.context=context;
        this.list=list;
    }
    private SetonItem setonItem;

    public void setSetonItem(SetonItem setonItem) {
        this.setonItem = setonItem;
    }

    //接口回调
    public interface SetonItem{
        void onItemLinister(int postion, int pid, View view);
    }
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==TYPE0){
            View view = View.inflate(context, R.layout.item1, null);
            MyViewHolder holder1 = new MyViewHolder(view);
            return holder1;
        }else if (viewType==TYPE1){
            View view = View.inflate(context, R.layout.item2, null);
            MyViewHolder2 holder2 = new MyViewHolder2(view);
          return holder2;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder){
            MyViewHolder myHolder = (MyViewHolder) holder;
            //Fresco图片加载
            String images = list.get(position).getImages().split("\\|")[0];
            Uri uri = Uri.parse(images);
            myHolder.shoplist_slv.setImageURI(uri);
            myHolder.tv_price.setText("￥"+list.get(position).getBargainPrice()+"");
            myHolder.tv_content.setText(list.get(position).getTitle());
        }else if (holder instanceof MyViewHolder2){
            MyViewHolder2 myPicHolder = (MyViewHolder2) holder;
            //Fresco图片加载
            String images = list.get(position).getImages().split("\\|")[0];
            Uri uri = Uri.parse(images);
            myPicHolder.shoplist_slv.setImageURI(uri);
            myPicHolder.tv_price.setText("￥"+list.get(position).getBargainPrice()+"");
            myPicHolder.tv_content.setText(list.get(position).getTitle());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pid = list.get(position).getPid();
                setonItem.onItemLinister(position,pid,view);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return TYPE0;
        }else{
            return TYPE1;
        }
    }


    class MyViewHolder extends XRecyclerView.ViewHolder {
        private final SimpleDraweeView shoplist_slv;
        private final TextView tv_content;
        private final TextView tv_price;
        public MyViewHolder(View itemView) {

            super(itemView);
            shoplist_slv = itemView.findViewById(R.id.shoplist_slv);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }

     class MyViewHolder2 extends XRecyclerView.ViewHolder{
         private final SimpleDraweeView shoplist_slv;
         private final TextView tv_content;
         private final TextView tv_price;
         public MyViewHolder2(View itemView) {
             super(itemView);
             shoplist_slv = itemView.findViewById(R.id.shoplist_slv);
             tv_content = itemView.findViewById(R.id.tv_content);
             tv_price = itemView.findViewById(R.id.tv_price);
         }
     }
}
