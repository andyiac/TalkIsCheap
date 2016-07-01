package com.andyiac.talkischeap.fragment;



/**
 * Created by summer on 16-7-1.
 */
public class IjkPlayerTestFragment extends BaseToolBarFragment {

    @Override
    protected void initToolBarView() {
        setToolbarDisplayHomeAsUp(true);
        setToolbarTitle(IjkPlayerTestFragment.class.getSimpleName());
    }


    public void playVideo(String url, String name) {
        VideoActivity.intentTo(getActivity(), url, name);
    }

}
