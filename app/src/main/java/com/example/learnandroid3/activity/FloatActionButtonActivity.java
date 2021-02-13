package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.learnandroid3.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FloatActionButtonActivity extends AppCompatActivity {
    FloatingActionButton fabMain, fabFb, fabTw, fabGg;
    boolean isShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_action_button);
        addControls();
        setEvents();
    }

    private void setEvents() {
        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isShow){
                    fabFb.show();
                    fabTw.show();
                    fabGg.show();
                    isShow = true;
                }else{
                    fabFb.hide();
                    fabTw.hide();
                    fabGg.hide();
                    isShow = false;
                }

            }
        });
    }

    private void addControls() {
        fabMain = findViewById(R.id.fabMain);
        fabFb = findViewById(R.id.fabFb);
        fabTw = findViewById(R.id.fabTw);
        fabGg = findViewById(R.id.fabGg);
    }
}