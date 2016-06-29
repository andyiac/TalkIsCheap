package com.andyiac.talkischeap.fragment;

import android.os.Bundle;

/**
 * andyiac
 * 16/6/23
 */
public class OthersFragment extends BaseToolBarFragment {


    public static OthersFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        OthersFragment fragment = new OthersFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onStart() {
        super.onStart();

    }


}
