package com.wak.animtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.wak.animtest.transition.TransitionOneActivity;
import com.wak.animtest.transition.TransitionTwoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        TextView tvTransitionAnim = findViewById(R.id.tvTransitionAnim);
        TextView tvChangeClipBounds = findViewById(R.id.tvChangeClipBounds);
        tvTransitionAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TransitionOneActivity.class);
                startActivity(intent);
            }
        });
        tvChangeClipBounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TransitionTwoActivity.class);
                startActivity(intent);
            }
        });

    /*    startActivity(new Intent(MainActivity.this, TransitionTwoActivity.class)
                , ActivityOptions.makeSceneTransitionAnimation(this).toBundle());*/
        Pair<TextView, String> test1 = Pair.create(tvChangeClipBounds, "test1");
        ActivityOptionsCompat.makeSceneTransitionAnimation(this, new Pair[]{test1});
    }
}
