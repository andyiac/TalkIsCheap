package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.R;

/**
 * andyiac
 * 16/6/23
 */
public class BaseToolBarFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.base_toolbar_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {


    }

    @Override
    public void onStart() {

        super.onStart();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    public void setToolbarDisplayHomeAsUp() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
    }

    public void setToolbarDisplayHomeAsUpWithTitle(String title) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);

    }

    public void setToolbarDisplayHomeAsTitle(int title) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);

    }

    public void setToolbarDisplayHomeAsTitle(String title) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
    }


}
