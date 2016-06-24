package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.view.View;

/**
 * andyiac  16/6/23
 *
 * 稳定的 demo 放到这里来
 *
 * 适当的进行分类
 */
public class SavedFragment extends BaseFragment {


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

        if (mButton != null) {
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(SavedFragment.newInstance(mInt + 1));
                    }
                }
            });
            mButton.setText(getClass().getSimpleName() + " " + mInt);
        }

    }


}
