package com.andyiac.talkischeap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.andyiac.talkischeap.interact_js.WebViewJsInteractActivity;
import com.andyiac.talkischeap.interceptor_html.AndroidInterceptorHtmlActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void onClickTest(View view) {
        Toast.makeText(this, "onTest", Toast.LENGTH_SHORT).show();
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

    public void onClickGetPackageInfo(View view){
        Toast.makeText(this,getPackageName(),Toast.LENGTH_SHORT).show();
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
