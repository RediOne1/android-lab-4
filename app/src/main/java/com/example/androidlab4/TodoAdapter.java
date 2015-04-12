package com.example.androidlab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Adrian on 2015-04-12.
 */
public class TodoAdapter extends BaseAdapter {

    private List<String> todoList;
    private LayoutInflater inflater;

    public TodoAdapter(Context context, List<String> todoList){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.todoList = todoList;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public String getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.todo_item, null);
        }
        TextView title = (TextView) convertView.findViewById(R.id.todo_title);
        title.setText(getItem(position));
        return convertView;
    }
}
