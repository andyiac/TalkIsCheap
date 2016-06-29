package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.andyiac.talkischeap.R;

/**
 * andyiac
 * 16/6/23
 */
public class HomeFragmentBack extends BaseToolBarFragment {


    Button mButton;

    public static HomeFragmentBack newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        HomeFragmentBack fragment = new HomeFragmentBack();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment_back_test, container, false);
        mButton = (Button) view.findViewById(R.id.button);
        return view;
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

        setToolbarDisplayHomeAsTitle(getClass().getSimpleName() + " " + mInt);
        setToolbarDisplayHomeAsUpWithTitle(getClass().getSimpleName() + " " + mInt);

    }


}
