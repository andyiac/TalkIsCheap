package com.andyiac.talkischeap.fragment;

import android.os.Bundle;

/**
 * andyiac  16/6/23
 * <p>
 * 稳定的 demo 放到这里来
 * <p>
 * 适当的进行分类
 */
public class SavedFragment extends BaseToolBarFragment {


    public static SavedFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        SavedFragment fragment = new SavedFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onStart() {
        super.onStart();


    }


}
