package com.andyiac.talkischeap.interact_js;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.andyiac.talkischeap.R;

/**
 * @author andyiac
 * @date 12/28/15
 * @web www.andyiac.com
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();

        setContentView(R.layout.webview_second_activity);


    }
}
