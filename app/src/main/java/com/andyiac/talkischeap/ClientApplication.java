package com.andyiac.talkischeap;

import android.app.Application;

import com.liulishuo.filedownloader.FileDownloader;
import com.orhanobut.logger.Logger;


/**
 * @author andyiac
 * @date 12/28/15
 * @web www.andyiac.com
 */
public class ClientApplication extends Application {

    private static final String TAG = "TALK_IS_CHEAP";

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        FileDownloader.init(this);
    }

    private void initLogger() {
        Logger.init(TAG);
    }

}
