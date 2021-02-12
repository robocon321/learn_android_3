package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid3.R;

public class TouchEventActivity extends AppCompatActivity {
    TextView txtTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
        txtTouch = findViewById(R.id.txtTouch);
        GestureDetector gestureDetector = new GestureDetector(this, new TouchEvent());
        txtTouch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        });
    }

    public class TouchEvent extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            txtTouch.setText("onDoubleTap");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDown(MotionEvent e) {
            txtTouch.setText("onDown");
            return super.onDown(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
            txtTouch.setText("onLongPress");
        }

        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
            txtTouch.setText("onShowPress");
        }
    }
}