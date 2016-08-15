package com.andyiac.talkischeap.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by summer on 16-6-15.
 */
public class ScreenUtils {


    private static Map<String, Object> valueCache = new HashMap<>();

    public static final String KEY_SCREEN_WIDTH = "key_screen_width";
    public static final String KEY_SCREEN_HEIGHT = "key_screen_height";
    public static final String KEY_SCREEN_DENSITY = "key_screen_density";

    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static float getScreenDensity(Activity activity) {
        if (valueCache.get(KEY_SCREEN_DENSITY) != null) {
            return (float) valueCache.get(KEY_SCREEN_DENSITY);
        } else {
            DisplayMetrics outMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
            valueCache.put(KEY_SCREEN_DENSITY, outMetrics.density);
            return outMetrics.density;
        }
    }

    public static int getScreenWidth(Activity activity) {

        if (valueCache.get(KEY_SCREEN_WIDTH) != null) {
            return (int) valueCache.get(KEY_SCREEN_WIDTH);
        } else {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            valueCache.put(KEY_SCREEN_WIDTH, point.x);
            return point.x;
        }

    }

    public static int getScreenHight(Activity activity) {

        if (valueCache.get(KEY_SCREEN_HEIGHT) != null) {
            return (int) valueCache.get(KEY_SCREEN_HEIGHT);
        } else {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            valueCache.put(KEY_SCREEN_HEIGHT, point.y);
            return point.y;
        }
    }


}
