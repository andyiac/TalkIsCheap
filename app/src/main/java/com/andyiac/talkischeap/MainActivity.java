package com.andyiac.talkischeap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.andyiac.talkischeap.activity.HorizontalRecyclerViewActivity;
import com.andyiac.talkischeap.activity.OverScrollActivity;
import com.andyiac.talkischeap.activity.PopWindowTestActivity;
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
}
