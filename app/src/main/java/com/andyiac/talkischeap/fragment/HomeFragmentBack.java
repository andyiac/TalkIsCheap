package com.andyiac.talkischeap.fragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;

/**
 * andyiac
 * 16/6/23
 */
public class HomeFragmentBack extends BaseFragment {


    public static HomeFragmentBack newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        HomeFragmentBack fragment = new HomeFragmentBack();
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
                        mFragmentNavigation.pushFragment(HomeFragmentBack.newInstance(mInt + 1));
                    }
                }
            });
            mButton.setText(getClass().getSimpleName() + " " + mInt);
        }


        getActivity().getActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);

    }




}
