package com.andyiac.talkischeap.activity;

import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.utils.downloader.SimpleDownloader;
import com.andyiac.talkischeap.utils.downloader.StorageUtils;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
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
    String pdfUrl= "http://www.andyiac.com/pdf/problemandroid.pdf";
    String pdfUrl2 = "http://www.pdf995.com/samples/pdf.pdf";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view_activity);
        savePath = StorageUtils.getCacheDirectory(this).getPath();
//        com.andyiac.talkischeap.utils.FileUtils fileUtils = new com.andyiac.talkischeap.utils.FileUtils(this);
//        savePath = fileUtils.getStorageDirectory();


        //showPdf(); // 直接让webView 显示pdf 在国内不可行

        initView();

        //downloadPdf(pdfUrl2, savePath); // 此方法savePath是绝对方法

        testDemoDownloader();


    }

    PDFView pdfView;

    private void initView() {
        pdfView = (PDFView) findViewById(R.id.pdfview);

    }


    private void showPdf(File file) {

        Logger.e("========show pdf ======");


        pdfView.fromFile(file)
                //.pages(0, 2, 1, 3, 3, 3)
                .defaultPage(1)
                .swipeVertical(true)
                .showMinimap(false)
                .enableSwipe(true)
                .load();

    }



    private void testDemoDownloader() {
        SimpleDownloader downloader = new SimpleDownloader(this, pdfUrl2, savePath, "bp.pdf");
        downloader.startDownload();
        downloader.setOnDownloadFinishListener(new SimpleDownloader.OnDownloadFinishListener() {

            @Override
            public void onDownloadFinish(final String fileAbsolutePath) {
//                startActivity(getPdfFileIntent(fileAbsolutePath));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        File pdfFile = new File(fileAbsolutePath);
                        showPdf(pdfFile);

                    }
                }, 2000);

                Logger.e("=======open file=====" + fileAbsolutePath);
            }

            @Override
            public void downloadProgress(int progress) {
                Logger.e("======progress=====>>>" + progress);
            }

            @Override
            public void onDownloadIntercept(boolean intercept) {

            }
        });

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


    // ==========================================================================================
    /*
    private void showPdf() {
        Logger.e("=============================================================================");
        WebView webview = (WebView) findViewById(R.id.pdf_web_view);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());

        webview.loadUrl("http://www.andyiac.com/pdf/problemandroid.pdf");
        //webview.loadUrl("http://docs.google.com/gview?embedded=true&url=http://myurl.com/demo.pdf");
        //webview.loadUrl("http://docs.google.com/gview?embedded=true&url="+"http://www.andyiac.com/pdf/problemandroid.pdf");

    }*/

    private void downloadPdf(String url, String path) {
        Logger.e("==========download pdf =======");
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

                        File pdfFile = new File(savePath);
                        showPdf(pdfFile);

                        //startActivity(getPdfFileIntent(savePath));

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


}
