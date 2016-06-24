package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andyiac.talkischeap.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * andyiac
 * 16/6/23
 */
public class MeFragment extends BaseFragment {


    public static MeFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Element adsElement = new Element();
        adsElement.setTitle("Advertise with us");


        return new AboutPage(getActivity())
                .isRTL(false)
                .setImage(R.mipmap.login_icon1)
                .addItem(new Element().setTitle("Version 1.1.1"))
                .addItem(adsElement)
                .addGroup("Connect with us")
                .addEmail("andyiaczhang@gmail.com")
                .addWebsite("http://andyiac.com/")
                .addFacebook("andyiaczhang")
                .addTwitter("andyiaczhang")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.andyiac")
                .addGitHub("andyiac")
                .addInstagram("andyiac")
                .setDescription("Talk is cheap is a personal app contains a lot of dev tricks from my personal work")
                .create();
    }

    @Override
    public void onStart() {
        super.onStart();
    }


}
