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
import com.andyiac.talkischeap.utils.StorageUtils;
import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.orhanobut.logger.Logger;

import java.io.File;

/**
 * @author andyiac
 * @date 2/29/16
 * @web www.andyiac.com
 */
public class PDFViewActivity extends AppCompatActivity {

    private String savePath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view_activity);

        //showPdf();

        String pdfUrl = "http://www.andyiac.com/pdf/problemandroid.pdf";
        String pdfUrl2 = "http://www.pdf995.com/samples/pdf.pdf";
        savePath = StorageUtils.getCacheDirectory(this).getPath() + "aaa.pdf";
        downloadPdf(pdfUrl2, savePath);
    }


    private void downloadPdf(String url, String path) {
        FileDownloader.getImpl().create(url)
                .setPath(path)
                .setListener(new FileDownloadListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                    }

                    @Override
                    protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Logger.e("progress=====>>" + soFarBytes + "of" + totalBytes);
                    }

                    @Override
                    protected void blockComplete(BaseDownloadTask task) {
                    }

                    @Override
                    protected void retry(final BaseDownloadTask task, final Throwable ex, final int retryingTimes, final int soFarBytes) {
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        Logger.e("-----------download completed ------------------");

                        startActivity(getPdfFileIntent(savePath));

                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {
                    }
                }).start();
    }


    // ==========================================================================================
    private void showPdf() {
        Logger.e("=============================================================================");
        WebView webview = (WebView) findViewById(R.id.pdf_web_view);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());

        webview.loadUrl("http://www.andyiac.com/pdf/problemandroid.pdf");
        //webview.loadUrl("http://docs.google.com/gview?embedded=true&url=http://myurl.com/demo.pdf");
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
