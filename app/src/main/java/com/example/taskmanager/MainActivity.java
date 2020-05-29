package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int reqCode = 12345;

    Button btnAdd;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> taskDisplay = new ArrayList<Task>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        lv = findViewById(R.id.lv);

        DBHelper db = new DBHelper(MainActivity.this);
        taskDisplay = db.getAllTask();
        db.close();

        aa = new TaskAdapter(getApplicationContext(),R.layout.row,taskDisplay);
        lv.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(i, 9);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 9) {
            DBHelper db = new DBHelper(MainActivity.this);
            taskDisplay.clear();
            taskDisplay.addAll(db.getAllTask());
            db.close();
            aa.notifyDataSetChanged();
        }
    }


}
