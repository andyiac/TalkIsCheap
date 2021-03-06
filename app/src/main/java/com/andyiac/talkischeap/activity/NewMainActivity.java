package com.andyiac.talkischeap.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.andyiac.talkischeap.BaseActivity;
import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.activity.tracks.FragNavController;
import com.andyiac.talkischeap.fragment.BaseFragment;
import com.andyiac.talkischeap.fragment.HomeFragment;
import com.andyiac.talkischeap.fragment.MeFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * andyiac
 * 16/6/22
 */
public class NewMainActivity extends BaseActivity implements BaseFragment.FragmentNavigation {


    private BottomBar mBottomBar;

    private FragNavController mNavController;

    //Better convention to properly name the indices what they are in your app
    private final int INDEX_RECENTS = FragNavController.TAB1;
    private final int INDEX_FAVORITES = FragNavController.TAB2;
    private final int INDEX_NEARBY = FragNavController.TAB3;
    private final int INDEX_FRIENDS = FragNavController.TAB4;
    private final int INDEX_FOOD = FragNavController.TAB5;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_main_activity);

        initToolbar();
        initView(savedInstanceState);
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.new_main_activity_toolbar);
        setSupportActionBar(mToolbar);
    }

    private void initView(Bundle savedInstanceState) {

        List<Fragment> fragments = new ArrayList<>(4);

        fragments.add(HomeFragment.newInstance(0));
        fragments.add(HomeFragment.newInstance(0));
        fragments.add(HomeFragment.newInstance(0));
        fragments.add(MeFragment.newInstance(0));

        mNavController = new FragNavController(savedInstanceState, getSupportFragmentManager(), R.id.container, fragments);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.useOnlyStatusBarTopOffset();

        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {

                switch (menuItemId) {

                    case R.id.bottomBarItemOne:
                        mNavController.switchTab(INDEX_RECENTS);
                        break;

                    case R.id.bottomBarItemOne1:
                        mNavController.switchTab(INDEX_FAVORITES);
                        break;

                    case R.id.bottomBarItemOne2:
                        mNavController.switchTab(INDEX_NEARBY);
                        break;

                    case R.id.bottomBarItemOne3:
                        mNavController.switchTab(INDEX_FRIENDS);
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

                switch (menuItemId) {

                    case R.id.bottomBarItemOne:
                        Toast.makeText(NewMainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottomBarItemOne1:
                        break;
                    case R.id.bottomBarItemOne2:
                        break;
                    case R.id.bottomBarItemOne3:
                        break;
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);

        mNavController.onSaveInstanceState(outState);
    }


    @Override
    public void onBackPressed() {
        if (mNavController.getCurrentStack().size() > 1) {
            mNavController.pop();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void pushFragment(Fragment fragment) {
        mNavController.push(fragment);
    }


}
