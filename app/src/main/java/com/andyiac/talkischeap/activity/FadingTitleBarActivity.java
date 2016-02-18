package com.andyiac.talkischeap.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.andyiac.talkischeap.R;

/**
 * @author andyiac
 * @date 2/18/16
 * @web www.andyiac.com
 */
public class FadingTitleBarActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fading_title_bar_activity);
    }
}
