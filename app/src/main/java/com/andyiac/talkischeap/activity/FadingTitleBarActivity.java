package com.andyiac.talkischeap.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.view.custom.NotifyingScrollView;
import com.orhanobut.logger.Logger;

/**
 * @author andyiac
 * @date 2/18/16
 * @web www.andyiac.com
 * <p/>
 * <p/>
 * <p/>
 * this is refer http://cyrilmottier.com/2013/05/24/pushing-the-actionbar-to-the-next-level/
 * <p/>
 * for more demo
 * https://github.com/AChep/Header2ActionBar
 * <p/>
 * https://github.com/ManuelPeinado/FadingActionBar  star 2564
 */
public class FadingTitleBarActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fading_title_bar_activity);

        linearLayout = (LinearLayout) findViewById(R.id.ll_title_bar_header);

        mActionBarBackgroundDrawable = getResources().getDrawable(R.drawable.bg_alert_dialog_frame_new);
        mActionBarBackgroundDrawable.setAlpha(0);

        linearLayout.setBackgroundDrawable(mActionBarBackgroundDrawable);
//        getActionBar().setBackgroundDrawable(mActionBarBackgroundDrawable);

        ((NotifyingScrollView) findViewById(R.id.scroll_view)).setOnScrollChangedListener(mOnScrollChangedListener);

    }


    private Drawable mActionBarBackgroundDrawable;


    private NotifyingScrollView.OnScrollChangedListener mOnScrollChangedListener = new NotifyingScrollView.OnScrollChangedListener() {
        public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
            final int headerHeight = findViewById(R.id.ll_title_bar_header).getHeight();
            Logger.e(" header height =====>>" + headerHeight + "==== t=====>> " + t);
            //- getActionBar().getHeight();
            final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
            Logger.e(" ratio =====>>" + ratio);
            final int newAlpha = (int) (ratio * 255);
            mActionBarBackgroundDrawable.setAlpha(newAlpha);
        }
    };
}

