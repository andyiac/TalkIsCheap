package com.andyiac.talkischeap.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.andyiac.talkischeap.R;

/**
 * 底部控件，随软键盘弹出，跟着上移
 * 在AndroidManifast 中设置 如下就会使 底部的『我已阅读并同意小饭桌条款』随着键盘一起飘起来
 * android:windowSoftInputMode="adjustResize
 * <p/>
 * andyiac  16/5/9
 */

public class SoftInputModeTestActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_input_with_bottom_test);
    }
}
