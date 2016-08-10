package com.andyiac.talkischeap.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.R;

import java.util.Arrays;
import java.util.List;

/**
 * @author andyiac
 * @date 1/29/16
 * @web www.andyiac.com
 */
public class DoubleRecyclerViewVerticalAdapter extends RecyclerView.Adapter<DoubleRecyclerViewVerticalAdapter.MyHolder> {

    private Context mContext;

    private List<String> mData;

    public DoubleRecyclerViewVerticalAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
        View view = View.inflate(parent.getContext(), R.layout.double_list_item_view, null);
        // 创建一个ViewHolder
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        //holder.mTextView.setText(mData.get(position));
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        holder.horizontalRecyclerView.setLayoutManager(layoutManager);

        String[] data = new String[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = "item " + i;
        }

        DoubleRecyclerViewHorizontalAdapter horizontalAdapter = new
                DoubleRecyclerViewHorizontalAdapter(Arrays.asList(data));

        holder.horizontalRecyclerView.setAdapter(horizontalAdapter);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        //public TextView mTextView;
        public RecyclerView horizontalRecyclerView;

        public MyHolder(View itemView) {
            super(itemView);
            //  mTextView = (TextView) itemView;
            horizontalRecyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_horizontal);
        }
    }
}
