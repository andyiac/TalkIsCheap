package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.ClientApplication;
import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.adapter.AutoScrollHorizontalRecyclerViewAdapter;
import com.andyiac.talkischeap.utils.ScreenUtils;
import com.orhanobut.logger.Logger;

import java.util.Arrays;

/**
 * @author andyiac
 * @date 1/29/16
 * @web www.andyiac.com
 */
public class AutoScrollHorizontalRecyclerViewFragment extends BaseToolBarFragment {

    private boolean D = ClientApplication.DEBUG;
    private String[] dataset;
    private int screenWidth;


    @Override
    protected void initToolBarView() {
        setToolbarTitle(getClass().getSimpleName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.auto_scroll_item_horizontal_recyler_view, container, false);
        initHorizontal(view);
        return view;
    }


    private void initHorizontal(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_horizontal);

        // 创建一个线性布局管理器
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // 设置布局管理器
        recyclerView.setLayoutManager(layoutManager);

        // 创建数据集
        dataset = new String[8];
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = "item" + i;
        }

        // 创建Adapter，并指定数据集
        AutoScrollHorizontalRecyclerViewAdapter adapter = new AutoScrollHorizontalRecyclerViewAdapter(Arrays.asList(dataset), recyclerView);
        // 设置Adapter
        recyclerView.setAdapter(adapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            /**
             * Callback method to be invoked when RecyclerView's scroll state changes.
             *
             * @param recyclerView The RecyclerView whose scroll state has changed.
             * @param newState     The updated scroll state. One of {link #SCROLL_STATE_IDLE},
             *                     { link #SCROLL_STATE_DRAGGING} or {link #SCROLL_STATE_SETTLING}.
             */
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                if (D) Log.i("onScrollStateChanged", "-------");
                scrollChange(recyclerView, newState, mSumDx, 0);

                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mSumDx += dx;
                if (D) Log.e("onScrolled", dx + "");
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        //layoutManager.scrollToPosition(2);

        int density = (int) ScreenUtils.getScreenDensity(getActivity());
        screenWidth = ScreenUtils.getScreenWith(getActivity());
        if (D) Logger.e("density" + density + "screen width ==>" + screenWidth);

    }


    int mSumDx;
    int listItemWidth = 300;

    private void scrollChange(RecyclerView recyclerView, int newState, int dx, int dy) {

        if (D) Log.e("TAG", "=== scroll change====" + newState);

        switch (newState) {
            case RecyclerView.SCROLL_STATE_IDLE:

                if (D) Log.e("TAG", "=== dx=>>" + dx);

                if (dx > 0) { // 向前滑动

                    if (D) Log.e("TAG", "=== dx=>>" + dx + "==== mSumDx ==>" + mSumDx);

                    int remain = mSumDx % listItemWidth;

                    // 滑动大于 一半 把剩下的帮用户滑完
                    if (remain >= listItemWidth / 2) {
                        recyclerView.smoothScrollBy(listItemWidth - remain, 0);
                    } else {

                        // 如果滑到最后一项完全出来 不处理

                        if (mSumDx == listItemWidth * dataset.length - screenWidth) {

                            return;
                        }

                        // 滑动小于一半 划回去
                        recyclerView.smoothScrollBy(-remain, 0);

                    }

                } else if (dx < 0) { // 向后滑动

                    if (D) Log.i("TAG", "dx <0");

                }

                break;

            case RecyclerView.SCROLL_STATE_DRAGGING:

                break;

            case RecyclerView.SCROLL_STATE_SETTLING:

                break;
        }


    }

}
