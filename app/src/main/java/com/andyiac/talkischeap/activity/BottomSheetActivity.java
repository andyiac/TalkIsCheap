package com.andyiac.talkischeap.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.andyiac.talkischeap.R;
import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.cocosw.bottomsheet.BottomSheet;
import com.orhanobut.logger.Logger;

/**
 * @author andyiac
 * @date 2/24/16
 * @web www.andyiac.com
 */
public class BottomSheetActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_activity);


    }

    public void onClickBottomSheet(View view) {
        new BottomSheet.Builder(this)
//                .title("  test   ")

                .sheet(R.menu.bottom_sheet_activity)
                .grid()
                .listener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case R.id.share:
                                Logger.e("==============");
                                break;
                        }
                    }
                }).show();
    }



    AlertView mAlertView;
    public void onClickAlertView(View view){

        String[] message = new String[]{"删除", "复制"};
        mAlertView = new AlertView(null, null, "取消", null, message, this, AlertView.Style.ActionSheet, new OnItemClickListener() {
            @Override
            public void onItemClick(Object o, int position) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                }
            }
        });
        mAlertView.show();
    }
}
