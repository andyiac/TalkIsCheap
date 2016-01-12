package com.andyiac.talkischeap.activitys;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.view.scroll.OverScrollView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author andyiac
 * @date 1/12/16
 * @web www.andyiac.com
 * <p/>
 * OverScrollView 必须得包含一个子view 才能使用
 */
public class OverScrollActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> mDatas = new ArrayList<>();
    private OverScrollView mOverScrollView;
    String[] a = {"item 1", "item 2 ", "list", "android", "item 3", "foobar", "bar"};
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.over_scroll_activity);


        mDatas.addAll(Arrays.asList(a));

        mListView = (ListView) findViewById(R.id.id_lv_over_scroll);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDatas);
        mListView.setAdapter(mAdapter);

        mOverScrollView = (OverScrollView) findViewById(R.id.over_scrollView);
        mOverScrollView.setOverScroll(true);
        mOverScrollView.setOverScrollListener(new OverScrollView.OverScrollListener() {
            @Override
            public void headerScroll() {

                mDatas.clear();
                mDatas.addAll(Arrays.asList(a));
                mAdapter.notifyDataSetChanged();

                showLoadingProgressDialog();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dismissLoadingProgressDialog();
                    }
                }, 1000);


            }

            @Override
            public void footerScroll() {

                mDatas.addAll(Arrays.asList(a));
                mAdapter.notifyDataSetChanged();
                showLoadingProgressDialog();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dismissLoadingProgressDialog();
                    }
                }, 1000);

            }
        });


    }


    AlertDialog alertDialog;

    protected void showLoadingProgressDialog() {

        if (alertDialog == null) {
            alertDialog = new AlertDialog.Builder(this).setCancelable(true).create();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            alertDialog.getWindow().setDimAmount(0);
        }

        if (!alertDialog.isShowing()) {
            alertDialog.show();
        }

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.getWindow().setContentView(R.layout.loading_dialog);

    }

    protected void dismissLoadingProgressDialog() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }

    }


}
