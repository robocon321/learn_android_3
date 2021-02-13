package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.learnandroid3.R;

public class ScaleActivity extends AppCompatActivity {
    ImageView imgScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        imgScale = findViewById(R.id.imgScale);
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(this, new ScaleEvent());
        imgScale.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scaleGestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    public class ScaleEvent extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            Log.d("event", "onScale");
            float zoom = detector.getScaleFactor()*detector.getScaleFactor();
            imgScale.setScaleX(zoom);
            imgScale.setScaleY(zoom);
            return super.onScale(detector);
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Log.d("event", "onScaleBegin");
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            Log.d("event", "onScaleEnd");
            super.onScaleEnd(detector);
        }
    }
}