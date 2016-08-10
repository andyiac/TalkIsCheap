package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by summer
 * on 16-8-10.
 * 横向 纵向 双向 listview
 */
public class DoubleListViewFragment extends BaseToolBarFragment {


    @BindView(R.id.double_list_rv_1)
    RecyclerView mRecyclerViewHorizental;

    //@BindView(R.id.double_list_rv_2) RecyclerView mRecyclerViewVertical;

    @Override
    protected void initToolBarView() {
        setToolbarDisplayHomeAsUp(true);
        String title = getClass().getSimpleName();
        setToolbarTitle(title);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.double_list_view_fragment, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
    }

}
