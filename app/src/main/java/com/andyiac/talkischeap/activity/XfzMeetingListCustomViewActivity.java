package com.andyiac.talkischeap.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.adapter.XFZMeetingListAdapter;
import com.orhanobut.logger.Logger;

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

    ImageView mArrowBtnLeft;
    ImageView mArrowBtnRight;


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

        for (int i = 0; i < 16; i++) {
            addNewPager();
            viewPager.setCurrentItem(7);
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Logger.e("====position==>>" + position + "\n" + positionOffset + "\n" + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Logger.e("====position select ==>>" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Logger.e("====state==>>" + state);

            }
        });

        mArrowBtnRight = (ImageView) findViewById(R.id.xfz_date_slider_right_btn);
        mArrowBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        });

        mArrowBtnLeft = (ImageView) findViewById(R.id.xfz_date_slider_left_btn);
        mArrowBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = viewPager.getCurrentItem();
                if (current - 1 >= 0) {
                    viewPager.setCurrentItem(current - 1, true);
                }
            }
        });
    }

    private void addNewPager() {

        View v = LayoutInflater.from(this).inflate(R.layout.xfz_date_slider_view_item, null);

        TextView tvContent1 = (TextView) v.findViewById(R.id.xfz_data_slider_item_content1);
        TextView tvContent2 = (TextView) v.findViewById(R.id.xfz_data_slider_item_content2);
        TextView tvContent3 = (TextView) v.findViewById(R.id.xfz_data_slider_item_content3);

        tvContent1.setText(0 + "");
        tvContent2.setText(1 + "");
        tvContent3.setText(2 + "");


        adapter.addPagerView(v);
    }


}
