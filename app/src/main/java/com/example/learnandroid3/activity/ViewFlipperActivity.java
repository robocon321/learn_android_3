package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.learnandroid3.R;

public class ViewFlipperActivity extends AppCompatActivity {
    int[] images = new int[]{R.drawable.close, R.drawable.open, R.drawable.android, R.drawable.call, R.drawable.delete};
    ViewFlipper viewFlipper;
    Button btnNext, btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper = findViewById(R.id.viewFlipper);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        initViewFlipper();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setAutoStart(false);
                viewFlipper.stopFlipping();
                viewFlipper.showNext();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.setAutoStart(false);
                viewFlipper.stopFlipping();
                viewFlipper.showPrevious();
            }
        });
    }

    private void initViewFlipper() {
        for(int i: images){
            ImageView img = new ImageView(this);
            img.setImageResource(i);
            viewFlipper.addView(img);
        }

        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.out));
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.in));
    }
}