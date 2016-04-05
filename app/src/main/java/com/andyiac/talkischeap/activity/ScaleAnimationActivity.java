package com.andyiac.talkischeap.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.andyiac.talkischeap.R;

/**
 * Created by andyiac on 16/4/5.
 */
public class ScaleAnimationActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scale_animation_activity);
        initView();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.image_view);
    }


    public void onClickBegin(View view) {
        Toast.makeText(ScaleAnimationActivity.this, "begin", Toast.LENGTH_SHORT).show();

        scaleView(imageView, 0.5f, 0.5f);


    }

    public void onClickStop(View view) {
        Toast.makeText(ScaleAnimationActivity.this, "stop show", Toast.LENGTH_SHORT).show();
        scaleView(imageView, 1.0f, 1.0f);
    }


    // 居中 等比 缩放
    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(2000);
        v.startAnimation(anim);
    }

}
