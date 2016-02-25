package com.andyiac.talkischeap.view.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;

/**
 * @author andyiac
 * @date 2/25/16
 * @web www.andyiac.com
 */
public class FixedAlertView extends AlertView{

    public FixedAlertView(String title, String msg, String cancel, String[] destructive, String[] others, Context context, Style style, OnItemClickListener onItemClickListener) {
        super(title, msg, cancel, destructive, others, context, style, onItemClickListener);
    }


    @Override
    protected void initAlertViews(LayoutInflater layoutInflater) {
        super.initAlertViews(layoutInflater);


//
//        ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(com.bigkoo.alertview.R.layout.layout_alertview_alert, contentContainer);
//        initHeaderView(viewGroup);
//
//        int position = 0;
//        //如果总数据小于等于HORIZONTAL_BUTTONS_MAXCOUNT，则是横向button
//        if(mDatas.size()<=HORIZONTAL_BUTTONS_MAXCOUNT){
//            ViewStub viewStub = (ViewStub) contentContainer.findViewById(com.bigkoo.alertview.R.id.viewStubHorizontal);
//            viewStub.inflate();
//            LinearLayout loAlertButtons = (LinearLayout) contentContainer.findViewById(com.bigkoo.alertview.R.id.loAlertButtons);
//            for (int i = 0; i < mDatas.size(); i ++) {
//                //如果不是第一个按钮
//                if (i != 0){
//                    //添加上按钮之间的分割线
//                    View divier = new View(context);
//                    divier.setBackgroundColor(context.getResources().getColor(com.bigkoo.alertview.R.color.bgColor_divier));
//                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int)context.getResources().getDimension(com.bigkoo.alertview.R.dimen.size_divier), LinearLayout.LayoutParams.MATCH_PARENT);
//                    loAlertButtons.addView(divier,params);
//                }
//                View itemView = LayoutInflater.from(context).inflate(com.bigkoo.alertview.R.layout.item_alertbutton, null);
//                TextView tvAlert = (TextView) itemView.findViewById(com.bigkoo.alertview.R.id.tvAlert);
//                tvAlert.setClickable(true);
//
//                //设置点击效果
//                if(mDatas.size() == 1){
//                    tvAlert.setBackgroundResource(com.bigkoo.alertview.R.drawable.bg_alertbutton_bottom);
//                }
//                else if(i == 0){//设置最左边的按钮效果
//                    tvAlert.setBackgroundResource(com.bigkoo.alertview.R.drawable.bg_alertbutton_left);
//                }
//                else if(i == mDatas.size() - 1){//设置最右边的按钮效果
//                    tvAlert.setBackgroundResource(com.bigkoo.alertview.R.drawable.bg_alertbutton_right);
//                }
//                String data = mDatas.get(i);
//                tvAlert.setText(data);
//
//                //取消按钮的样式
//                if (data == cancel){
//                    tvAlert.setTypeface(Typeface.DEFAULT_BOLD);
//                    tvAlert.setTextColor(context.getResources().getColor(com.bigkoo.alertview.R.color.textColor_alert_button_cancel));
//                    tvAlert.setOnClickListener(new OnTextClickListener(CANCELPOSITION));
//                    position = position - 1;
//                }
//                //高亮按钮的样式
//                else if (mDestructive!= null && mDestructive.contains(data)){
//                    tvAlert.setTextColor(context.getResources().getColor(com.bigkoo.alertview.R.color.textColor_alert_button_destructive));
//                }
//
//                tvAlert.setOnClickListener(new OnTextClickListener(position));
//                position++;
//                loAlertButtons.addView(itemView,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT, 1));
//            }
//        }
//        else{
//            ViewStub viewStub = (ViewStub) contentContainer.findViewById(com.bigkoo.alertview.R.id.viewStubVertical);
//            viewStub.inflate();
//            initListView();
//        }









    }
}
