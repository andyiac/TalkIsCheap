package com.andyiac.talkischeap.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.andyiac.talkischeap.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * andyiac
 * 16/5/17
 */
public class EventBusDemoActivity extends AppCompatActivity {

    private Button testBtn;

    private TextView testTvView;

    private int age = 18;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_bus_demo_activity);
        testBtn = (Button) findViewById(R.id.id_btn_test_event_bus);
        testTvView = (TextView) findViewById(R.id.id_tv_test_event_bus);

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBusDemoActivity.MessageEvent.User user = new EventBusDemoActivity.MessageEvent.User();
                user.setName("andyiac");
                user.setAge(age++ + "");

                EventBus.getDefault().post(user);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe
    public void onEvent(MessageEvent.User user) {
        testTvView.setText(user.getName() + "\n" + user.getAge());
    }

    public static class MessageEvent {

        public static class User {
            String name;
            String age;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }
        }
    }

}
