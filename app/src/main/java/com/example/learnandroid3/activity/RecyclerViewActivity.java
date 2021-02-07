package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.learnandroid3.R;
import com.example.learnandroid3.adapter.ItemAdapter;
import com.example.learnandroid3.utils.Item;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.android, "Android"));
        list.add(new Item(R.drawable.edit, "Edit"));
        list.add(new Item(R.drawable.download, "Download"));
        list.add(new Item(R.drawable.windows, "Windows"));
        list.add(new Item(R.drawable.ubuntu, "Ubuntu"));

        ItemAdapter adapter = new ItemAdapter(list, this);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
    }
}