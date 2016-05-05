package com.andyiac.talkischeap.activity.image.cropper;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.andyiac.talkischeap.R;
import com.lyft.android.scissors.CropView;

import java.io.File;

import rx.Observable;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

import static android.graphics.Bitmap.CompressFormat.JPEG;
import static rx.android.schedulers.AndroidSchedulers.mainThread;
import static rx.schedulers.Schedulers.io;

/**
 * andyiac
 * 16/5/5
 */
public class ScissorsActivity extends AppCompatActivity {


    private CropView mCropView;

    CompositeSubscription subscriptions = new CompositeSubscription();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.scissors_activity);
        initView();
    }

    private void initView() {

        mCropView = (CropView) findViewById(R.id.crop_view);
    }


    public void onClickStartCrop(View view) {
        final File croppedFile = new File(getCacheDir(), "cropped.jpg");

        Observable<Void> onSave = Observable.from(mCropView.extensions()
                .crop()
                .quality(100)
                .format(JPEG)
                .into(croppedFile))
                .subscribeOn(io())
                .observeOn(mainThread());

        subscriptions.add(onSave
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void nothing) {
                        CropResultActivity.startUsing(croppedFile, ScissorsActivity.this);
                    }
                }));

    }

    public void onClickPickImage(View view) {
        mCropView.extensions().pickUsing(this, RequestCodes.PICK_IMAGE_FROM_GALLERY);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RequestCodes.PICK_IMAGE_FROM_GALLERY && resultCode == Activity.RESULT_OK) {

            Uri galleryPictureUri = data.getData();

            mCropView.extensions().load(galleryPictureUri);

            //updateButtons();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        subscriptions.unsubscribe();
    }

}
