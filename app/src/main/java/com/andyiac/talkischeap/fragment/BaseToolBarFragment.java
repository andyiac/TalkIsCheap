package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.activity.NewMainActivity;

/**
 * andyiac
 * 16/6/23
 */
public abstract class BaseToolBarFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.base_toolbar_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        initToolBarView();
    }

    protected abstract void initToolBarView();


    @Override
    public void onStart() {

        super.onStart();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    public void setToolbarDisplayHomeAsUp(boolean is_show_back) {
        ((NewMainActivity) getActivity()).showBack(is_show_back);
    }

    public void setToolbarTitle(String title) {
        ((NewMainActivity) getActivity()).setToolBarTitle(title);
    }

}
