package com.andyiac.talkischeap.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.adapter.XFZMeetingListAdapter;

/**
 * andyiac
 * 16/6/2
 * <p/>
 * <p/>
 * android 中
 */

public class XfzMeetingListCustomViewActivity extends AppCompatActivity {


    ViewPager viewPager;
    XFZMeetingListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xfz_meeting_list_custom_view_activity);
        initView();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.xfz_pager);

        adapter = new XFZMeetingListAdapter();


        viewPager.setAdapter(adapter);

        for (int i = 0; i < 10; i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.xfz_date_slider_view_item, null);
            adapter.addPagerView(v);
        }
    }


}
