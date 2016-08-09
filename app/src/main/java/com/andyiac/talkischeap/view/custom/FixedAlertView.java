package com.andyiac.talkischeap.view.custom;

import android.content.Context;
import android.view.LayoutInflater;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;

/**
 * @author andyiac
 * @date 2/25/16
 * @web www.andyiac.com
 */
public class FixedAlertView extends AlertView{

    public FixedAlertView(String title, String msg, String cancel, String[] destructive, String[] others, Context context, Style style, OnItemClickListener onItemClickListener) {
        super(title, msg, cancel, destructive, others, context, style, onItemClickListener);
    }


    @Override
    protected void initAlertViews(LayoutInflater layoutInflater) {
        super.initAlertViews(layoutInflater);

    }
}
