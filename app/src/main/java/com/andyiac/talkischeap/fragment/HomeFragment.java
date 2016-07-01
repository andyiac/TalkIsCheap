package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.ijkplayer.fragments.SampleMediaListFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * andyiac
 * 16/6/23
 */
public class HomeFragment extends BaseToolBarFragment {


    private Unbinder unbinder;

    public static HomeFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView(view);
        return view;
    }

    private void initView(View view) {

    }

    @Override
    protected void initToolBarView() {

        setToolbarDisplayHomeAsUp(false);
        setToolbarTitle(getResources().getString(R.string.app_name));

    }

    @Override
    public void onStart() {

        super.onStart();

    }


    @OnClick(R.id.id_home_test1)
    public void test() {
        Toast.makeText(getActivity(), "test click", Toast.LENGTH_SHORT).show();

        if (mFragmentNavigation != null) {
            mFragmentNavigation.pushFragment(BackStackTestFragment.newInstance(mInt + 1));
        }

    }

    @OnClick(R.id.id_home_test_ijkplayer)
    public void testIjkPlayer() {

        if (mFragmentNavigation != null) {
            // mFragmentNavigation.pushFragment(new IjkPlayerTestFragment());
            mFragmentNavigation.pushFragment(new SampleMediaListFragment());
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
