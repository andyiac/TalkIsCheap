package com.andyiac.talkischeap.activity;

import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.andyiac.talkischeap.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andyiac
 * @date 2/3/16
 * @web www.andyiac.com
 * <p>
 */
public class ListViewFooterLoadMoreActivity extends AppCompatActivity {


    private ListView mListView;
    private ArrayAdapter mAdapter;

    private List<String> mData = new ArrayList<>();
    private int lastItem;
    private int page = 1;
    private ProgressBar listViewProgressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.list_view_load_more_activity);


        mListView = (ListView) findViewById(R.id.id_list_load_more_lv);


        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mData);

        mListView.setAdapter(mAdapter);


        loadData();

        listViewProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
        ClipDrawable d = new ClipDrawable(new ColorDrawable(Color.YELLOW), Gravity.LEFT, ClipDrawable.HORIZONTAL);
        listViewProgressBar.setProgressDrawable(d);
        listViewProgressBar.setPadding(40, 40, 40, 40);
        listViewProgressBar.setVisibility(View.INVISIBLE);
        mListView.addFooterView(listViewProgressBar);

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Logger.e("====lastItem==" + lastItem + "\n"
                        + "=======mAdapter.getCount()===" + mAdapter.getCount() + "\n"
                        + "=====scrollState====" + scrollState + "\n"
                        + "=====Scroll state idle===" + AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                );
                if (lastItem == mAdapter.getCount() && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    listViewProgressBar.setVisibility(View.VISIBLE);
                    loadData();

                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                lastItem = firstVisibleItem + visibleItemCount - 1;
            }

        });

    }


    private void loadData() {

        mData.add("aaa1");
        mData.add("aaa2");
        mData.add("aaa3");
        mData.add("aaa4");
        mData.add("aaa5");
        mData.add("aaa6");
        mData.add("aaa6");
        mData.add("aaa6");
        mData.add("aaa6");
        mData.add("aaa6");
        mData.add("aaa6");
        mData.add("aaa6");
        mAdapter.notifyDataSetChanged();

    }
}
