package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.gesture.Gesture;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid3.R;

public class GestureActivity extends AppCompatActivity {
    Button btnTouchEvent, btnSwipe, btnMove, btnScale;

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
        btnMove = findViewById(R.id.btnMove);
        btnScale = findViewById(R.id.btnScale);
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

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestureActivity.this, MoveViewActivity.class);
                startActivity(intent);
            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestureActivity.this, ScaleActivity.class);
                startActivity(intent);
            }
        });
    }
}