package com.andyiac.talkischeap.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andyiac.talkischeap.ClientApplication;
import com.andyiac.talkischeap.R;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * @author andyiac
 * @date 1/29/16
 * @web www.andyiac.com
 */
public class AutoScrollHorizontalRecyclerViewAdapter extends RecyclerView.Adapter<AutoScrollHorizontalRecyclerViewAdapter.MyHolder> {


    private boolean D = false ;//ClientApplication.DEBUG;
    private List<String> mData;
    private RecyclerView mRecyclerView;

    public AutoScrollHorizontalRecyclerViewAdapter(List<String> data,RecyclerView recyclerView) {
        this.mData = data;
        this.mRecyclerView = recyclerView;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
        View view = View.inflate(parent.getContext(), R.layout.auto_scroll_list_item, null);
        // 创建一个ViewHolder
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.mTextView.setText(mData.get(position));

    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the { link ViewHolder# itemView}
     * to reflect the item at the given position.
     * <p/>
     *
     * Note that unlike {@link android.widget.ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined.
     *
     * For this reason, you should only use the <code>position</code> parameter while acquiring the
     * related data item inside this method and should not keep a copy of it.
     *
     * If you need the position of an item later  on (e.g. in a click listener),
     * use {@link ViewHolder#getAdapterPosition()} which will  have the updated adapter position.
     * <p/>
     *
     * Override {@link #onBindViewHolder(ViewHolder, int, List)} instead if Adapter can
     * handle effcient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */

    private int flag ;
    @Override
    public void onBindViewHolder(MyHolder holder, int position, List<Object> payloads) {

        if (D) Logger.e("=====>>>" + position);
        flag = position;
        //mRecyclerView.smoothScrollToPosition(flag);

        super.onBindViewHolder(holder, position, payloads);


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.auto_scroll_tv);
        }
    }
}
