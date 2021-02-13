package com.example.learnandroid3.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.learnandroid3.R;
import com.example.learnandroid3.adapter.ExpLvAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        ExpandableListView expandableListView = findViewById(R.id.expLv);

        ArrayList<String> parents = new ArrayList<>();
        parents.add("Parent 0");
        parents.add("Parent 1");
        parents.add("Parent 2");
        parents.add("Parent 3");

        ArrayList<String> child_p0 = new ArrayList<>();
       child_p0.add("Child 0 of parent 0");
       child_p0.add("Child 1 of parent 0");
       child_p0.add("Child 2 of parent 0");
       child_p0.add("Child 3 of parent 0");
       child_p0.add("Child 4 of parent 0");

        ArrayList<String> child_p1 = new ArrayList<>();
        child_p1.add("Child 0 of parent 1");
        child_p1.add("Child 1 of parent 1");
        child_p1.add("Child 2 of parent 1");
        child_p1.add("Child 3 of parent 1");

        ArrayList<String> child_p2 = new ArrayList<>();
        child_p2.add("Child 0 of parent 2");
        child_p2.add("Child 1 of parent 2");
        child_p2.add("Child 2 of parent 2");
        child_p2.add("Child 3 of parent 2");

        ArrayList<String> child_p3 = new ArrayList<>();
        child_p3.add("Child 0 of parent 3");
        child_p3.add("Child 1 of parent 3");
        child_p3.add("Child 2 of parent 3");
        child_p3.add("Child 3 of parent 3");

        HashMap<String, ArrayList<String>> contents = new HashMap<>();
        contents.put(parents.get(0), child_p0);
        contents.put(parents.get(1), child_p1);
        contents.put(parents.get(2), child_p2);
        contents.put(parents.get(3), child_p3);

        ExpLvAdapter adapter = new ExpLvAdapter(this, parents, contents);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(ExpandableListViewActivity.this, parents.get(groupPosition)+"", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ExpandableListViewActivity.this, contents.get(parents.get(groupPosition)).get(childPosition)+"", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}