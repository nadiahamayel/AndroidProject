package com.example.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;

    public MyAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView nameView = (TextView) rowView.findViewById(R.id.name);
        TextView timeView = (TextView) rowView.findViewById(R.id.time);
        TextView descView = (TextView) rowView.findViewById(R.id.desc);
        String[] favorite = values.get(position).split(" ");
        nameView.setText(favorite[0]);
        timeView.setText(favorite[1]);
        descView.setText(favorite[2]);
        return rowView;
    }
}
