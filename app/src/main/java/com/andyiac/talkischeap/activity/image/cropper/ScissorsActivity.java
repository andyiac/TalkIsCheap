package com.andyiac.talkischeap.activity.image.cropper;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.andyiac.talkischeap.R;
import com.lyft.android.scissors.CropView;

/**
 * andyiac
 * 16/5/5
 */
public class ScissorsActivity extends AppCompatActivity {


    private CropView mCropView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scissors_activity);
        initView();
    }

    private void initView() {

        mCropView = (CropView) findViewById(R.id.crop_view);
    }


    public void onClickStartCrop(View view) {


    }

    public void onClickPickImage(View view) {
        mCropView.extensions()
                .pickUsing(this, RequestCodes.PICK_IMAGE_FROM_GALLERY);
    }

}
