package com.andyiac.talkischeap.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;

import com.andyiac.talkischeap.R;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * @author andyiac
 * @date 2/2/16
 * @web www.andyiac.com
 */
public class PullAndLoadMoreQiuTestActivity extends AppCompatActivity {

    PtrFrameLayout ptrFrame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_and_loadmore_activity);

        initView2();

    }

    private void initView2() {
        ptrFrame = (PtrFrameLayout) findViewById(R.id.store_house_ptr_frame);
        ptrFrame.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // 默认实现，根据实际情况做改动
//                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
                return true;
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrame.refreshComplete();
                    }
                }, 1800);
            }
        });

    }


}
