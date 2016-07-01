package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.ijkplayer.activities.VideoActivity;

/**
 * Created by summer on 16-7-1.
 */
public class IjkPlayerTestFragment extends BaseToolBarFragment {

    @Override
    protected void initToolBarView() {
        setToolbarDisplayHomeAsUp(true);
        setToolbarTitle(IjkPlayerTestFragment.class.getSimpleName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.ijk_player_test, container, false);
        return view;
    }

    public void playVideo(String url, String name) {
        VideoActivity.intentTo(getActivity(), url, name);
    }

}
