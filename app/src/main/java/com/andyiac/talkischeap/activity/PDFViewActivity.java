package com.andyiac.talkischeap.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.andyiac.talkischeap.R;
import com.orhanobut.logger.Logger;

import java.io.File;

/**
 * @author andyiac
 * @date 2/29/16
 * @web www.andyiac.com
 */
public class PDFViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view_activity);
        showPdf();
    }


    private void showPdf() {
        Logger.e("============");
        WebView webview = (WebView) findViewById(R.id.pdf_web_view);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());

        Log.v("....hello....", "");
        //webview.loadUrl("http://docs.google.com/gview?embedded=true&url=http://myurl.com/demo.pdf");
        webview.loadUrl("http://www.andyiac.com/pdf/problemandroid.pdf");
        //webview.loadUrl("http://docs.google.com/gview?embedded=true&url="+"http://www.andyiac.com/pdf/problemandroid.pdf");

    }

    //android获取一个用于打开PDF文件的intent
    public static Intent getPdfFileIntent(String param) {

        Intent intent = new Intent("android.intent.action.VIEW");

        intent.addCategory("android.intent.category.DEFAULT");

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Uri uri = Uri.fromFile(new File(param));

        intent.setDataAndType(uri, "application/pdf");

        return intent;

    }

}
