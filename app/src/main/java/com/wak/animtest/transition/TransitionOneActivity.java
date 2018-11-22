package com.wak.animtest.transition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.ChangeTransform;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.wak.animtest.R;

public class TransitionOneActivity extends AppCompatActivity {

    private Button buttonTransform;
    private TextView tvContent;
    private ViewGroup mRootView;
    private FrameLayout container1;
    private FrameLayout container2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_transform);
        initView();
    }

    private void initView() {
        buttonTransform = findViewById(R.id.buttonTransform);
        tvContent = findViewById(R.id.tvContent);
        container1 = findViewById(R.id.container1);
        container2 = findViewById(R.id.container2);
        mRootView = (ViewGroup) getWindow().getDecorView();
        buttonTransform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(mRootView, new ChangeTransform());
                changeTransition();
            }
        });
    }

    private void changeTransition() {
        if (container2.getChildCount() > 0) {
            container2.removeAllViews();
            showRedSquare(container1);
            container1.getChildAt(0).setRotation(-45);
        } else {
            container1.removeAllViews();
            showRedSquare(container2);
            container2.getChildAt(0).setRotation(45);
        }
    }

    private void showRedSquare(ViewGroup container) {
        container.addView(tvContent);
    }
}
