package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid3.R;

public class SwipeActivity extends AppCompatActivity {
    TextView txtSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        txtSwipe = findViewById(R.id.txtSwipe);
        GestureDetector gestureDetector = new GestureDetector(this, new SwipeEvent());
        txtSwipe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    public class SwipeEvent extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            String distX = "Distance X: "+(e2.getX() - e1.getX());
            String distY = "Distance Y: "+(e2.getY() - e1.getY());
            String vX = "Velocity X: "+velocityX;
            String vY = "Velocity Y: "+velocityY;
            txtSwipe.setText(distX+"\n"+distY+"\n"+vX+"\n"+vY);
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}