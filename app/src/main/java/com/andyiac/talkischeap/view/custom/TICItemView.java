package com.andyiac.talkischeap.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andyiac.talkischeap.R;

/**
 * @author andyiac
 * @date 6/26/16
 * @web www.andyiac.com
 */
public class TICItemView extends LinearLayout {


    private TextView mTvTitle;
    private TextView mTvContent;

    public TICItemView(Context context) {
        this(context, null);
    }

    public TICItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TICItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        View view = LayoutInflater.from(context).inflate(R.layout.tic_item_view, this);
        mTvTitle = (TextView) view.findViewById(R.id.tic_item_view_title);
        mTvContent = (TextView) view.findViewById(R.id.tic_item_view_content);

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TICItemView, 0, 0);

        String title = a.getString(R.styleable.TICItemView_titleText);
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }

        String content = a.getString(R.styleable.TICItemView_contentText);
        if (!TextUtils.isEmpty(content)) {
            setContent(content);
        }

    }


    private void setTitle(String title) {
        mTvTitle.setText(title);
    }

    private void setContent(String content) {
        mTvContent.setText(content);
    }

    private void setBackground() {

    }

}
