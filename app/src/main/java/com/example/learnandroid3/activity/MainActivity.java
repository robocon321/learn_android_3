package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid3.R;
import com.example.learnandroid3.utils.MessageService;

public class MainActivity extends AppCompatActivity {
    Button btnRecyclerView, btnTabLayout, btnWindowManager, btnContact, btnOkHttp;
    Button btnGesture, btnViewFlipper, btnExpLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        setEVents();
    }

    public void addControls(){
        btnRecyclerView = findViewById(R.id.btnRecyclerView);
        btnTabLayout = findViewById(R.id.btnTabLayout);
        btnWindowManager = findViewById(R.id.btnWindowManager);
        btnContact = findViewById(R.id.btnContact);
        btnOkHttp = findViewById(R.id.btnOkHttp);
        btnGesture = findViewById(R.id.btnGesture);
        btnViewFlipper = findViewById(R.id.btnViewFlipper);
        btnExpLv = findViewById(R.id.btnExplv);
    }

    public void setEVents(){
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btnTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                startActivity(intent);
            }
        });

        btnWindowManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessageService.class);
                startService(intent);
                finish();
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });

        btnOkHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OkHttpActivity.class);
                startActivity(intent);
            }
        });

        btnGesture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureActivity.class);
                startActivity(intent);
            }
        });

        btnViewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewFlipperActivity.class);
                startActivity(intent);
            }
        });

        btnExpLv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExpandableListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}