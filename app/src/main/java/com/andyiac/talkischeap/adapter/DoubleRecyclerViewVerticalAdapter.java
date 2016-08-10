package com.andyiac.talkischeap.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author andyiac
 * @date 1/29/16
 * @web www.andyiac.com
 */
public class DoubleRecyclerViewVerticalAdapter extends RecyclerView.Adapter<DoubleRecyclerViewVerticalAdapter.MyHolder> {


    private List<String> mData;

    public DoubleRecyclerViewVerticalAdapter(List<String> data) {
        this.mData = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
        View view = View.inflate(parent.getContext(), android.R.layout.simple_list_item_1, null);
        // 创建一个ViewHolder
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.mTextView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
