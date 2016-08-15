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
        dataset = new String[9];
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = "item" + i;
        }

        // 创建Adapter，并指定数据集
        AutoScrollHorizontalRecyclerViewAdapter adapter = new AutoScrollHorizontalRecyclerViewAdapter(Arrays.asList(dataset), recyclerView);
        // 设置Adapter
        recyclerView.setAdapter(adapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            //  OnScrollListener 中先调用 onScrolled 再调用 onScrollStateChanged()
            // todo 去源码验证一下

            /**
             * Callback method to be invoked when RecyclerView's scroll state changes.
             *
             * @param recyclerView The RecyclerView whose scroll state has changed.
             * @param newState     The updated scroll state. One of {link #SCROLL_STATE_IDLE},
             *                     { link #SCROLL_STATE_DRAGGING} or {link #SCROLL_STATE_SETTLING}.
             */
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                //super.onScrollStateChanged(recyclerView, newState);
                if (D) Log.i("onScrollStateChanged", "-------");

                scrollChange(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //super.onScrolled(recyclerView, dx, dy);
                if (D) Log.i("onScrolled", "------->" + dx + "");
                mSumDx += dx;

            }
        });


        //layoutManager.scrollToPosition(2);

        screenWidth = ScreenUtils.getScreenWidth(getActivity());

    }


    int mSumDx;


    private void scrollChange(RecyclerView recyclerView, int newState) {

        if (D) Log.e("TAG", "=== scroll change====" + newState + "=== mSumDx=>>" + mSumDx);


        int density = (int) ScreenUtils.getScreenDensity(getActivity());

        if (D) Logger.e("====density====>>" + density + "====screen width ==>" + screenWidth);

        // TODO: 16/8/14 item with 在 Adapter 中拿不到 在 OnBindView holder 中拿到的 itemView 的宽度是 0 原因是 View 。。。。？
        int listItemWidth = recyclerView.getChildAt(0).getWidth();// 可以通过 Recycler 动态拿到宽度

        if (D) Log.e("TAG", "====list item width == >>" + listItemWidth);

        switch (newState) {

            case RecyclerView.SCROLL_STATE_IDLE:

                // 滑动的长度 == list 总长度 - 屏幕宽度
                int invisibleWidth = listItemWidth * dataset.length - screenWidth;

                if (D) Log.e("TAG", "====invisibleWidth=>>>" + invisibleWidth);

                if (mSumDx == invisibleWidth) {
                    // 如果滑到最后一项完全出来 不处理

                } else {

                    int remain = mSumDx % listItemWidth;

                    if (remain >= listItemWidth / 2) {
                        // 滑动大于 一半 把剩下的帮用户滑完
                        recyclerView.smoothScrollBy(listItemWidth - remain, 0);
                    } else {
                        // 滑动小于一半 划回去
                        recyclerView.smoothScrollBy(-remain, 0);
                    }
                }

                break;
        }


    }

}
