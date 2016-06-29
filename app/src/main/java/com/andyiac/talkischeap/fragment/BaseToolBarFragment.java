package com.andyiac.talkischeap.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andyiac.talkischeap.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * andyiac
 * 16/6/23
 */
public class BaseToolBarFragment extends BaseFragment {


    private Unbinder unbinder;
    private Toolbar mToolbar;

    public static BaseToolBarFragment newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        BaseToolBarFragment fragment = new BaseToolBarFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        initView(view);
        return view;
    }

    private void initView(View view) {

        mToolbar = (Toolbar) view.findViewById(R.id.new_main_activity_toolbar);

        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_HOME_AS_UP);
    }

    @Override
    public void onStart() {

        super.onStart();

    }


    @OnClick(R.id.id_home_test1)
    public void test() {
        Toast.makeText(getActivity(), "test click", Toast.LENGTH_SHORT).show();

        if (mFragmentNavigation != null) {
            mFragmentNavigation.pushFragment(HomeFragmentBack.newInstance(mInt + 1));
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
