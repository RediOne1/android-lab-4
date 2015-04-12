package com.example.androidlab4;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ListActivity implements View.OnClickListener, ListView.OnItemLongClickListener {

    private static ListView lv;
    private static ArrayList<String> todoList;
    private static TodoAdapter todoAdapter;
    private Button addButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.todo_edit_text);

        lv = getListView();
        if (savedInstanceState != null)
            todoList = savedInstanceState.getStringArrayList("myTodoList");
        else
            todoList = new ArrayList<>();
        todoAdapter = new TodoAdapter(this, todoList);
        lv.setAdapter(todoAdapter);
        lv.setOnItemLongClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == addButton) {
            String todo = editText.getText().toString();
            if (todo != null)
                todoList.add(todo);
            todoAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Usunięto " + todoAdapter.getItem(position), Toast.LENGTH_SHORT).show();
        todoList.remove(position);
        todoAdapter.notifyDataSetChanged();
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle savedState) {
        super.onSaveInstanceState(savedState);
        savedState.putStringArrayList("myTodoList", todoList);
    }
}
