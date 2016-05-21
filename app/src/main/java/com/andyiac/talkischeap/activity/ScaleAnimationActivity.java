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
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling  // 中心点 of X
                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling // 中心点 of Y
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(2000);
        v.startAnimation(anim);
    }


    /**

     fromX：起始X坐标上的伸缩尺寸。

     toX：结束X坐标上的伸缩尺寸。

     fromY：起始Y坐标上的伸缩尺寸。

     toY：结束Y坐标上的伸缩尺寸。

     pivotXType：X轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。

     pivotXValue：X坐标的伸缩值。

     pivotYType：Y轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。

     pivotYValue：Y坐标的伸缩值。

     */


}
