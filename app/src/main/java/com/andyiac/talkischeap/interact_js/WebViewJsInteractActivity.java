package com.andyiac.talkischeap.interact_js;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.andyiac.talkischeap.R;

import java.util.HashMap;
import java.util.Map;

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

        /**
         * 下面是添加header的测试
         */
//        Map<String,String> extraHeaders = new HashMap<>();
//        extraHeaders.put("xfz","1234567890");
//        mWebView.loadUrl("http://cms.dev.xfz.cn/api/app_page/action_records/",extraHeaders);


        //mWebView.loadUrl("http://192.168.10.54/static/js/phone/phone.article.js");
    }

}
