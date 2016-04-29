package com.andyiac.talkischeap.utils.downloader;


import android.content.Context;
import android.os.Handler;
import android.os.Message;


import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author andyiac
 * @date 2016/03/01
 */
public class SimpleDownloader {

    private static final String TAG = "SimpleDownloader";

    private Context mContext;

    private String downloadUrl;

    private static String mSavePath = "";

    private String mFileAbsolutePath;

    /* 进度条与通知ui刷新的handler和msg常量 */
    private static final int DOWN_UPDATE = 1;
    private static final int DOWN_OVER = 2;
    private boolean interceptFlag = false;

    private static boolean d = true;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DOWN_UPDATE:
                    downloadFinishListener.downloadProgress(msg.arg1);
                    break;
                case DOWN_OVER:
                    downloadFinishListener.onDownloadFinish(mFileAbsolutePath);
                    break;
                default:
                    break;
            }
        }
    };

    private OnDownloadFinishListener downloadFinishListener;

    public interface OnDownloadFinishListener {
        void onDownloadFinish(String fileAbsolutePath);

        void downloadProgress(int progress);

        void onDownloadIntercept(boolean intercept);

    }

    public void setOnDownloadFinishListener(OnDownloadFinishListener listener) {
        this.downloadFinishListener = listener;
    }

    public void setOnIntercept(Boolean intercept) {
        this.interceptFlag = intercept;
    }

    /**
     * @param context
     * @param fileUrl
     * @param savePath
     * @param fileName
     */
    public SimpleDownloader(Context context, String fileUrl, String savePath, String fileName) {
        this.mSavePath = savePath;
        this.mContext = context;
        this.downloadUrl = fileUrl;
        this.mFileAbsolutePath = savePath + "/" + fileName;

        //savePath = StorageUtils.getCacheDirectory(mContext).getPath();
    }

    //外部接口让主Activity调用
    public void startDownload() {
        Logger.e("=======================");
        new Thread(mDownRunnable).start();
    }


    private Runnable mDownRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(downloadUrl);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                int length = conn.getContentLength();
                InputStream is = conn.getInputStream();

                File file = new File(mSavePath);
                if (!file.exists()) file.mkdir();

                String apkFile = mFileAbsolutePath;
                File ApkFile = new File(apkFile);
                FileOutputStream fos = new FileOutputStream(ApkFile);

                int count = 0;
                byte buf[] = new byte[1024];

                do {
                    int numread = is.read(buf);
                    count += numread;
                    int progress = (int) (((float) count / length) * 100);

                    //更新进度
                    Message updateMsg = new Message();
                    updateMsg.what = DOWN_UPDATE;
                    updateMsg.arg1 = progress;
                    mHandler.sendMessage(updateMsg);

                    if (numread <= 0) {
                        //下载完成通知安装
                        mHandler.sendEmptyMessage(DOWN_OVER);
                        break;
                    }
                    fos.write(buf, 0, numread);
                } while (!interceptFlag);//点击取消就停止下载.

                fos.close();
                is.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

}
