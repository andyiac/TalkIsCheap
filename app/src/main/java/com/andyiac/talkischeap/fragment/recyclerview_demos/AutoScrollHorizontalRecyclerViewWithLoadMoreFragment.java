package com.andyiac.talkischeap.fragment.recyclerview_demos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.ClientApplication;
import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.adapter.AutoScrollHorizontalRecyclerViewAdapter;
import com.andyiac.talkischeap.fragment.BaseToolBarFragment;
import com.andyiac.talkischeap.utils.ScreenUtils;

import java.util.Arrays;


// TODO: 16/8/15  这个东西 写出来没有一点儿扩展性 ！！！
public class AutoScrollHorizontalRecyclerViewWithLoadMoreFragment extends BaseToolBarFragment {

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

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        dataset = new String[9];
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = "item" + i;
        }

        AutoScrollHorizontalRecyclerViewAdapter adapter = new AutoScrollHorizontalRecyclerViewAdapter(Arrays.asList(dataset), recyclerView);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            //  OnScrollListener 中先调用 onScrolled 再调用 onScrollStateChanged()
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                scrollChange(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mSumDx += dx;
            }
        });

        screenWidth = ScreenUtils.getScreenWidth(getActivity());
    }

    int mSumDx; // X 轴上滑动的长度

    private void scrollChange(RecyclerView recyclerView, int newState) {

        int listItemWidth = recyclerView.getChildAt(0).getWidth();// 可以通过 Recycler 动态拿到宽度

        switch (newState) {
            case RecyclerView.SCROLL_STATE_IDLE:

                int invisibleWidth = listItemWidth * dataset.length - screenWidth;

                if (mSumDx == invisibleWidth) {

                } else {

                    int remain = mSumDx % listItemWidth;

                    // 滑动大于 一半 把剩下的帮用户滑完
                    if (remain >= listItemWidth / 2) {

                        // 帮用户滑完
                        recyclerView.smoothScrollBy(listItemWidth - remain, 0);
                    } else {
                        // 滑动小于一半 划回去
                        recyclerView.smoothScrollBy(-remain, 0);
                    }
                }

                break;

            case RecyclerView.SCROLL_STATE_DRAGGING:

                break;

            case RecyclerView.SCROLL_STATE_SETTLING:

                break;
        }


    }

}
