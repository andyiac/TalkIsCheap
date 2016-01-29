package com.andyiac.talkischeap.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.adapter.HorizontalRecyclerViewAdapter;

import java.util.Arrays;

/**
 * @author andyiac
 * @date 1/29/16
 * @web www.andyiac.com
 */
public class HorizontalRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizontal_recyler_view);
        initHorizontal();
    }


    private void initHorizontal() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_horizontal);

        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
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
