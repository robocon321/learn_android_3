package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.gesture.Gesture;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid3.R;

public class GestureActivity extends AppCompatActivity {
    Button btnTouchEvent, btnSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        addControls();
        setEvents();
    }

    public void addControls(){
        btnTouchEvent = findViewById(R.id.btnTouch);
        btnSwipe = findViewById(R.id.btnSwipe);
    }

    public void setEvents(){
        btnTouchEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestureActivity.this, TouchEventActivity.class);
                startActivity(intent);
            }
        });

        btnSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestureActivity.this, SwipeActivity.class);
                startActivity(intent);
            }
        });
    }
}