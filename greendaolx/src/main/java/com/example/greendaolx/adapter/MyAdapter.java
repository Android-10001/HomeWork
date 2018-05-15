package com.example.greendaolx.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.greendaolx.R;
import com.example.greendaolx.User;

import java.util.List;

/**
 * author:Created by jiangkerun on 2018/5/14.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<User> list;
    private Context context;

    public MyAdapter( Context context,List<User> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rec_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.recId.setText(list.get(position).getId().toString());
        holder.recName.setText(list.get(position).getName());
        holder.recAge.setText(list.get(position).getAge());
        holder.recAddress.setText(list.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final TextView recName;
        private final TextView recAge;
        private final TextView recAddress;
        private final TextView recId;

        public MyViewHolder(View itemView) {
            super(itemView);
            recId = itemView.findViewById(R.id.rec_id);
            recName = itemView.findViewById(R.id.rec_name);
            recAge=itemView.findViewById(R.id.rec_age);
            recAddress=itemView.findViewById(R.id.rec_address);
        }
    }
}
