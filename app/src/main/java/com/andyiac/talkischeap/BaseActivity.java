package com.andyiac.talkischeap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import butterknife.ButterKnife;

/**
 * andyiac
 * 16/6/22
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
