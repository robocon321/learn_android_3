package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.learnandroid3.R;

public class MoveViewActivity extends AppCompatActivity {
    ImageView imgMove;
    boolean isRag = false;
    float x = 0, y = 0, dx = 0, dy = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_view);
        imgMove = findViewById(R.id.imgMove);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200,200);
        layoutParams.topMargin = 0;
        layoutParams.leftMargin = 0;
        imgMove.setLayoutParams(layoutParams);
        imgMove.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) v.getLayoutParams();

                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case(MotionEvent.ACTION_DOWN):
                        dx = event.getRawX() - params.leftMargin;
                        dy = event.getRawY() - params.topMargin;
                        isRag = true;
                        break;
                    case(MotionEvent.ACTION_MOVE):
                        x = event.getRawX();
                        y = event.getRawY();

                        params.topMargin = (int) (y - dy);
                        params.leftMargin = (int) (x - dx);
                        params.bottomMargin = 2000;
                        params.rightMargin = 2000;
                        v.setLayoutParams(params);
                        break;
                    case(MotionEvent.ACTION_UP):
                        isRag = false;
                        break;
                }
                return true;
            }
        });
    }
}