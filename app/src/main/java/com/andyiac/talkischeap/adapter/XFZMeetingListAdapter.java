package com.andyiac.talkischeap.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * andyiac
 * 16/6/3
 */
public class XFZMeetingListAdapter extends PagerAdapter {

    private List<View> mContent = new ArrayList<>();

    @Override
    public int getCount() {
        return mContent.size();
    }

    public void addPagerView(View view) {
        mContent.add(view);
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mContent.get(position));
        return mContent.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mContent.get(position));
    }

}
