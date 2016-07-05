package com.andyiac.talkischeap.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.ijkplayer.widget.media.IjkVideoView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by summer on 16-7-1.
 */
public class IjkPlayerTestFragment extends BaseToolBarFragment {


    private Unbinder unbinder;

    public IjkVideoView mVideoView;

    @Override
    protected void initToolBarView() {
        setToolbarDisplayHomeAsUp(true);
        setToolbarTitle(IjkPlayerTestFragment.class.getSimpleName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.ijk_player_test, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        playVideo();
        return view;
    }

    private void initView(View view) {
        mVideoView = (IjkVideoView) view.findViewById(R.id.ijk_player_fragment_video_view);
    }

    @OnClick(R.id.ikj_player_fragment_play_btn)
    public void playVideo() {
        Toast.makeText(getActivity(), "play video", Toast.LENGTH_SHORT).show();
        String url = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
        String url2 = "http://vediopool.kssws.ks-cdn.com/record/live/1467091190196025/hls/1467091190196025.m3u8";
        String url3 = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
        String name = "test";

        mVideoView.setVideoURI(Uri.parse(url3));
        mVideoView.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mVideoView.stopPlayback();
        mVideoView.release(true);
        mVideoView.stopBackgroundPlay();
    }

}
