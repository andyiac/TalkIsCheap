package com.andyiac.talkischeap;

import android.content.Intent;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.andyiac.talkischeap.activity.BottomSheetActivity;
import com.andyiac.talkischeap.activity.FadingTitleBarActivity;
import com.andyiac.talkischeap.activity.EventBusDemoActivity;
import com.andyiac.talkischeap.activity.HorizontalRecyclerViewActivity;
import com.andyiac.talkischeap.activity.ImageBitmapMemoryTestActivity;
import com.andyiac.talkischeap.activity.ListViewFooterLoadMoreActivity;
import com.andyiac.talkischeap.activity.OverScrollActivity;
import com.andyiac.talkischeap.activity.PDFViewActivity;
import com.andyiac.talkischeap.activity.PopWindowTestActivity;
import com.andyiac.talkischeap.activity.PullAndLoadMoreQiuTestActivity;
import com.andyiac.talkischeap.activity.ScaleAnimationActivity;
import com.andyiac.talkischeap.activity.SoftInputModeTestActivity;
import com.andyiac.talkischeap.activity.XfzMeetingListCustomViewActivity;
import com.andyiac.talkischeap.activity.image.cropper.ScissorsActivity;
import com.andyiac.talkischeap.interact_js.WebViewJsInteractActivity;
import com.andyiac.talkischeap.interceptor_html.AndroidInterceptorHtmlActivity;

/**
 * 本工程致力实现各种各样的demo 和解决各种bug
 * 开发过程中尽量不使用第三方类库实现
 * 问题列表可以在一下找到
 * http://www.andyiac.com/stone/problemandroid/
 * 看来我应该给每个问题编号这样以后查阅起来才更方便
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    //===========================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //===========================================================================

    public void onClickWebViewJsInteracts(View view) {
        Intent intent = new Intent();
        intent.setClass(this, WebViewJsInteractActivity.class);
        startActivity(intent);
    }

    public void onClickAndroidInterceptorHtmlActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, AndroidInterceptorHtmlActivity.class);
        startActivity(intent);
    }

    public void onClickGetPackageInfo(View view) {
        Toast.makeText(this, getPackageName(), Toast.LENGTH_SHORT).show();
    }

    // Test over scroll view
    public void onClickOverScrollActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(this, OverScrollActivity.class);
        startActivity(intent);
    }

    public void onClickPopWindow(View view) {
        Intent intent = new Intent();
        intent.setClass(this, PopWindowTestActivity.class);
        startActivity(intent);
    }

    public void onClickRecyclerView(View view) {
        Intent intent = new Intent();
        intent.setClass(this, HorizontalRecyclerViewActivity.class);
        startActivity(intent);
    }


    public void onClickRefreshView(View view) {
//        Intent intent = new Intent();
//        intent.setClass(this, PullAndLoadMoreActivity.class);
//        startActivity(intent);
    }

    public void onClickRefreshQiuDaView(View view) {
        Intent intent = new Intent();
        intent.setClass(this, PullAndLoadMoreQiuTestActivity.class);
        startActivity(intent);
    }

    public void onClickLoadMore(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ListViewFooterLoadMoreActivity.class);
        startActivity(intent);

    }


    public void onClickBatteryManager(View view) {
        BatteryManager bm = (BatteryManager) getSystemService(BATTERY_SERVICE);
//        bm.isCharging();
//        Toast.makeText(this, bm.isCharging() + "", Toast.LENGTH_SHORT).show();
//        int status = bm.getIntProperty(Integer.MIN_VALUE);

    }

    public void onClickFadingTitleBar(View view) {
        Intent intent = new Intent(this, FadingTitleBarActivity.class);
        startActivity(intent);
    }

    public void onClickBottomSheet(View view) {
        Intent intent = new Intent(this, BottomSheetActivity.class);
        startActivity(intent);

    }

    public void onClickViewPdf(View view) {
        Intent intent = new Intent(this, PDFViewActivity.class);
        startActivity(intent);
    }

    public void onClickTestAnimation(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ScaleAnimationActivity.class);
        startActivity(intent);
    }

    public void onClickScissors(View view) {
        Intent intent = new Intent();
        intent.setClass(this, ScissorsActivity.class);
        startActivity(intent);
    }

    public void onClickImageMemoryTest(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ImageBitmapMemoryTestActivity.class);
        startActivity(intent);

    }

    public void onClickLinearLayoutSoftInputTest(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SoftInputModeTestActivity.class);
        startActivity(intent);

    }

    public void onClickEventBusDemo(View view) {
        Intent intent = new Intent();
        intent.setClass(this, EventBusDemoActivity.class);
        startActivity(intent);
    }

    public void onClickXfzMeetingListCustomView(View view) {

        Intent intent = new Intent();
        intent.setClass(this, XfzMeetingListCustomViewActivity.class);
        startActivity(intent);


    }


    /**
     * 全角半角测试
     */
    public void test_half_width() {
        /*
        // 全角 ＠
        // 半角 @
        String s = "ning＠xfz.cn";
        String s2 = "ning@xfz.cn";

        if(s.contains("@")){
            Toast.makeText(MainActivity.this, "包含 全角at", Toast.LENGTH_SHORT).show();
        }
        */
    }


}
