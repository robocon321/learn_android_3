package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid3.R;

public class MainActivity extends AppCompatActivity {
    Button btnRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        setEVents();
    }

    public void addControls(){
        btnRecyclerView = findViewById(R.id.btnRecyclerView);
    }

    public void setEVents(){
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}