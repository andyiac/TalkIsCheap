package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.view.View;

/**
 * andyiac
 * 16/6/23
 */
public class OthersFragment extends BaseFragment {


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

        if (mButton != null) {
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(OthersFragment.newInstance(mInt + 1));
                    }
                }
            });
            mButton.setText(getClass().getSimpleName() + " " + mInt);
        }

    }


}
