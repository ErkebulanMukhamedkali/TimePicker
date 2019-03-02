package com.example.timepicker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<MyClass> {

    ArrayList<MyClass> alarms;

    public MyAdapter(@NonNull Context context, ArrayList<MyClass> resource) {
        super(context, R.layout.list_item);
        this.alarms = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View clock_view = inflater.inflate(R.layout.list_item, parent, false);

        TextView time = clock_view.findViewById(R.id.time);
        TextView note = clock_view.findViewById(R.id.notee);
        Switch swch = clock_view.findViewById(R.id.swich);

        time.setText(alarms.get(position).getTime());
        note.setText(alarms.get(position).getNote());
        swch.setChecked(true);

        return clock_view;
    }

    @Override
    public int getCount() {
        return alarms.size();
    }
}
