package com.andyiac.talkischeap.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andyiac.talkischeap.R;
import com.andyiac.talkischeap.activity.BottomSheetActivity;
import com.andyiac.talkischeap.activity.EventBusDemoActivity;
import com.andyiac.talkischeap.activity.FadingTitleBarActivity;
import com.andyiac.talkischeap.activity.HorizontalRecyclerViewActivity;
import com.andyiac.talkischeap.activity.ImageBitmapMemoryTestActivity;
import com.andyiac.talkischeap.activity.ListViewFooterLoadMoreActivity;
import com.andyiac.talkischeap.activity.OverScrollActivity;
import com.andyiac.talkischeap.activity.PDFViewActivity;
import com.andyiac.talkischeap.activity.PopWindowTestActivity;
import com.andyiac.talkischeap.activity.PullAndLoadMoreQiuTestActivity;
import com.andyiac.talkischeap.activity.ScaleAnimationActivity;
import com.andyiac.talkischeap.activity.SoftInputModeTestActivity;
import com.andyiac.talkischeap.activity.XfzMeetingListCustomViewActivity;
import com.andyiac.talkischeap.activity.image.cropper.ScissorsActivity;
import com.andyiac.talkischeap.interact_js.WebViewJsInteractActivity;
import com.andyiac.talkischeap.interceptor_html.AndroidInterceptorHtmlActivity;

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.id_home_test1)
    public void test() {
        Toast.makeText(getActivity(), "test click", Toast.LENGTH_SHORT).show();

        if (mFragmentNavigation != null) {
            mFragmentNavigation.pushFragment(BackStackTestFragment.newInstance(mInt + 1));
        }

    }


    @OnClick(R.id.id_home_web_view_js_interface)
    public void onClickWebViewJsInteracts() {
        Intent intent = new Intent();
        intent.setClass(getActivity(), WebViewJsInteractActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.id_home_interceptor_html_activity)
    public void onClickAndroidInterceptorHtmlActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), AndroidInterceptorHtmlActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_get_package_info)
    public void onClickGetPackageInfo(View view) {
        Toast.makeText(getActivity(), getActivity().getPackageName(), Toast.LENGTH_SHORT).show();
    }


    // Test over scroll view
    @OnClick(R.id.id_home_over_scroll)
    public void onClickOverScrollActivity(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), OverScrollActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_pop_window)
    public void onClickPopWindow(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), PopWindowTestActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_recycler_view)
    public void onClickRecyclerView(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), HorizontalRecyclerViewActivity.class);
        startActivity(intent);
    }


    public void onClickRefreshView(View view) {
//        Intent intent = new Intent();
//        intent.setClass(this, PullAndLoadMoreActivity.class);
//        startActivity(intent);
    }

    @OnClick(R.id.id_home_pull_and_loadmore)
    public void onClickRefreshQiuDaView(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), PullAndLoadMoreQiuTestActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_loadmore)
    public void onClickLoadMore(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ListViewFooterLoadMoreActivity.class);
        startActivity(intent);

    }


    @OnClick(R.id.id_home_batter_manager)
    public void onClickBatteryManager(View view) {
        BatteryManager bm = (BatteryManager) getActivity().getSystemService(Activity.BATTERY_SERVICE);
//        bm.isCharging();
//        Toast.makeText(this, bm.isCharging() + "", Toast.LENGTH_SHORT).show();
//        int status = bm.getIntProperty(Integer.MIN_VALUE);
    }

    @OnClick(R.id.id_home_fading_title_bar)
    public void onClickFadingTitleBar(View view) {
        Intent intent = new Intent(getActivity(), FadingTitleBarActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_bottom_sheet)
    public void onClickBottomSheet(View view) {
        Intent intent = new Intent(getActivity(), BottomSheetActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_view_pdf)
    public void onClickViewPdf(View view) {
        Intent intent = new Intent(getActivity(), PDFViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_test_animation)
    public void onClickTestAnimation(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ScaleAnimationActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_scissors)
    public void onClickScissors(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ScissorsActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_memory_test)
    public void onClickImageMemoryTest(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), ImageBitmapMemoryTestActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.id_home_soft_input)
    public void onClickLinearLayoutSoftInputTest(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), SoftInputModeTestActivity.class);
        startActivity(intent);

    }

    @OnClick(R.id.id_home_event_bus)
    public void onClickEventBusDemo(View view) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), EventBusDemoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_home_custom_listview)
    public void onClickXfzMeetingListCustomView(View view) {

        Intent intent = new Intent();
        intent.setClass(getActivity(), XfzMeetingListCustomViewActivity.class);
        startActivity(intent);
    }


    /**
     * 全角半角测试
     */
    public void test_half_width() {
        /*
        // 全角 ＠
        // 半角 @
        String s = "ning＠xfz.cn";
        String s2 = "ning@xfz.cn";

        if(s.contains("@")){
            Toast.makeText(MainActivity.this, "包含 全角at", Toast.LENGTH_SHORT).show();
        }
        */
    }

    @OnClick(R.id.id_home_double_list_view)
    public void testDoubleListView() {
        if (mFragmentNavigation != null) {
            mFragmentNavigation.pushFragment(new DoubleListViewFragment());
        }

    }

}
