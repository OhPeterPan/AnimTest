package com.wak.animtest.transition;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.ChangeClipBounds;
import android.support.transition.TransitionManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.wak.animtest.R;

public class TransitionTwoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_clip_counds);
        initView();
    }

    private void initView() {
        Button button = findViewById(R.id.button);
        final ImageView iv = findViewById(R.id.iv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rect rect = new Rect(20, 20, 150, 100);
                TransitionManager.beginDelayedTransition((ViewGroup) getWindow().getDecorView(), new ChangeClipBounds());
                if (rect.equals(ViewCompat.getClipBounds(iv))) {
                    ViewCompat.setClipBounds(iv, null);
                } else {
                    ViewCompat.setClipBounds(iv, rect);
                }
            }
        });
    }
}
