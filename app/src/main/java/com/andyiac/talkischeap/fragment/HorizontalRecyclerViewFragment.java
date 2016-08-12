package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.adapter.HorizontalRecyclerViewAdapter;

import java.util.Arrays;

/**
 * @author andyiac
 * @date 1/29/16
 * @web www.andyiac.com
 */
public class HorizontalRecyclerViewFragment extends BaseToolBarFragment {


    @Override
    protected void initToolBarView() {
        setToolbarTitle(getClass().getSimpleName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.horizontal_recyler_view, container, false);
        initHorizontal(view);
        return view;
    }


    private void initHorizontal(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_horizontal);

        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // 设置布局管理器
        recyclerView.setLayoutManager(layoutManager);

        // 创建数据集
        String[] dataset = new String[100];
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = "item" + i;
        }
        // 创建Adapter，并指定数据集
        HorizontalRecyclerViewAdapter adapter = new HorizontalRecyclerViewAdapter(Arrays.asList(dataset));
        // 设置Adapter
        recyclerView.setAdapter(adapter);
    }


}
