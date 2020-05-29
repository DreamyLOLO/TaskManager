package com.example.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> taskArray;
    private Context context;
    private TextView tvid;
    private TextView tvname;
    private TextView tvdesc;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        taskArray = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvid = (TextView)rowView.findViewById(R.id.tvID);
        tvname = (TextView)rowView.findViewById(R.id.tvName);
        tvdesc = (TextView)rowView.findViewById(R.id.tvDesc);

        Task task = taskArray.get(position);

        tvid.setText(""+task.getId());
        tvname.setText(task.getTitle());
        tvdesc.setText(task.getDescription());

        return rowView;

    }

}
