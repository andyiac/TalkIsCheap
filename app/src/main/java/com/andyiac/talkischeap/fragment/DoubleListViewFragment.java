package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.R;

/**
 * Created by summer
 * on 16-8-10.
 * 横向 纵向 双向 listview
 */
public class DoubleListViewFragment extends BaseToolBarFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.double_list_view_fragment, container, false);
        return view;
    }

    @Override
    protected void initToolBarView() {
        setToolbarDisplayHomeAsUp(true);
        String title = getClass().getSimpleName() + " " + mInt;
        setToolbarTitle(title);
    }
}
