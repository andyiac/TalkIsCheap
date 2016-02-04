package com.andyiac.talkischeap.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.andyiac.talkischeap.R;


/**
 * @author andyiac
 * @date 1/28/16
 * @web www.andyiac.com
 */
public class PopWindowTestActivity extends AppCompatActivity {


    private PopupWindow mPopWindow;

    private String[] testdatas = {"物流", "物流2", "物流3", "物流4", "adsfa"};

    private Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_case_list_activity);
        mBtn = (Button) findViewById(R.id.btn_project_case_drop_down);
        initPopWindow();
    }

    public void onClickDropDownMenu(View view) {
        togglePopWindow();
    }

    private void initPopWindow() {
        View popContent = getLayoutInflater().from(this).inflate(R.layout.pop_window, null, false);

        mPopWindow = new PopupWindow(popContent, LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT);


        // 设置点击返回键使其消失，且不影响背景，此时setOutsideTouchable函数即使设置为false
        // 点击PopupWindow 外的屏幕，PopupWindow依然会消失；相反，如果不设置BackgroundDrawable
        // 则点击返回键PopupWindow不会消失，同时，即时setOutsideTouchable设置为true
        // 点击PopupWindow 外的屏幕，PopupWindow依然不会消失
        mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
        mPopWindow.setOutsideTouchable(false);
        mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f; //0.0-1.0
                getWindow().setAttributes(lp);
            }
        });
        // mPopWindow.setAnimationStyle(R.style.PopupAnimation); // 设置动画
    }


    private void togglePopWindow() {
        if (mPopWindow.isShowing()) {
            Toast.makeText(this, "dismiss!", Toast.LENGTH_SHORT).show();
            mPopWindow.dismiss();
        } else {
            Toast.makeText(this, "show!", Toast.LENGTH_SHORT).show();
            mPopWindow.showAsDropDown(mBtn, 0, 0);
            //pw.showAsDropDown(titleName);
            // 计算x轴方向的偏移量，使得PopupWindow在Title的正下方显示，此处的单位是pixels
            // int xoffInPixels = ScreenTools.getInstance(PopDemoActivity.this).getWidth() / 2 - titleName.getWidth() / 2;

            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.alpha = 0.5f; //0.0-1.0
            getWindow().setAttributes(lp);

            mPopWindow.update();
        }
    }
}
