package com.example.learnandroid3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.learnandroid3.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpLvAdapter extends BaseExpandableListAdapter {
    Context context;
    ArrayList<String> headers;
    HashMap<String, ArrayList<String>> contents;

    public ExpLvAdapter(Context context, ArrayList<String> headers, HashMap<String, ArrayList<String>> contents) {
        this.context = context;
        this.headers = headers;
        this.contents = contents;
    }

    @Override
    public int getGroupCount() {
        return headers.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return contents.get(headers.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headers.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return contents.get(headers.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.layout_parent, null);
        TextView txt = view.findViewById(R.id.txtExpLv);
        txt.setText(headers.get(groupPosition));
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.layout_child, null);
        TextView txt = view.findViewById(R.id.txtExpLvChild);
        txt.setText(contents.get(headers.get(groupPosition)).get(childPosition));
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
