package com.andyiac.talkischeap.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.andyiac.talkischeap.R;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by andyiac on 5/21/16.
 * <p>
 * 使用volley 下载网上的图片 测试生成bitmap 占用内存的大小
 * <p>
 * 同时测试保存bitmap到文件的方法
 * <p>
 * 在XFZ app 中保存bitmap到文件方法多次导致OOM
 */
public class ImageBitmapMemoryTestActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_bitmap_memory_test_activity);
        initView();
        initData();
    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.id_memory_test_img);
    }


    private void initData() {

        mDataRootPath = getCacheDir().getPath();

        String img_url = "http://e.hiphotos.baidu.com/image/pic/item/dcc451da81cb39db02807657d2160924ab18306a.jpg";
        RequestQueue mQueue = Volley.newRequestQueue(this);
        ImageRequest imageRequest = new ImageRequest(
                img_url,
                new com.android.volley.Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(final Bitmap bitmap_src) {

                        Bitmap bitmap = Bitmap.createScaledBitmap(bitmap_src, 200, 300, true);

                        int height = bitmap.getHeight();
                        int width = bitmap.getWidth();
                        int size = bitmap.getRowBytes() * height;

                        Logger.e("height ==>>" + height + " \n" +
                                "width ===>>" + width + "\n" +
                                "size =====" + size + " \n" +
                                "getByteCount" + bitmap.getByteCount() + "\n" +
                                "get row bytes " + bitmap.getRowBytes()
                        );

                        mImageView.setImageBitmap(bitmap);
                        savaBitmap("jestfor.jpg", bitmap);

                    }
                }, 0, 0, Bitmap.Config.ALPHA_8, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        mQueue.add(imageRequest);
    }


    /**
     * 保存Image的方法，有sd卡存储到sd卡，没有就存储到手机目录
     *
     * @param fileName
     * @param bitmap_src
     */
    public void savaBitmap(String fileName, Bitmap bitmap_src) {
        if (bitmap_src == null) {
            return;
        }
//        Bitmap bitmap = Bitmap.createScaledBitmap(bitmap_src,200,300,true);

        String path = getStorageDirectory();
        File folderFile = new File(path);
        if (!folderFile.exists()) {
            folderFile.mkdir();
        }
        File file = new File(path + File.separator + fileName);

        String path2 = file.getAbsolutePath();
        Logger.e("=======path ====>>" + path2);

        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            bitmap_src.compress(Bitmap.CompressFormat.JPEG, 99, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * sd卡的根目录
     */
    private static String mSdRootPath = Environment.getExternalStorageDirectory().getPath();
    /**
     * 手机的缓存根目录
     */
    private static String mDataRootPath = null;
    /**
     * 保存Image的目录名
     */
    private final static String FOLDER_NAME = "/AndroidImage";


    /**
     * 获取储存Image的目录
     *
     * @return
     */
    public String getStorageDirectory() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ?
                mSdRootPath + FOLDER_NAME : mDataRootPath + FOLDER_NAME;
    }


}
