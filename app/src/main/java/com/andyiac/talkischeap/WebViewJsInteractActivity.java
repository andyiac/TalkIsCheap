package com.andyiac.talkischeap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import cn.pedant.SafeWebViewBridge.InjectedChromeClient;

/**
 * @author andyiac
 * @date 12/26/15
 * @web www.andyiac.com
 * <p/>
 * 微信 点击分享链接中的图片变大
 * 大象公会 中的类似
 */
public class WebViewJsInteractActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_js_interact_activity);

        mWebView = (WebView) findViewById(R.id.web_view_js_interact);

        WebSettings ws = mWebView.getSettings();
        ws.setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new InjectedChromeClient("XFZ_App", HostJsScope.class));
        mWebView.loadUrl("file:///android_asset/test.html");
        //mWebView.loadUrl("http://192.168.10.54/static/js/phone/phone.article.js");
    }

}
