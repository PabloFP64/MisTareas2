package com.example.mistareas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mistareas2.task_database.TaskContract;
import com.example.mistareas2.task_database.TaskDatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TaskDatabaseHelper taskHelper;
    private ListView TaskList;
    private ArrayAdapter<String> arrAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra(CrearTarea.EXTRA_REPLY);

        taskHelper = new TaskDatabaseHelper(this);
        TaskList = (ListView) findViewById(R.id.list_todo);

        if(nombre!=null){
            crearTarea();
        }

    }

    private void crearTarea() {
        Intent intent = getIntent();
        String nombre = intent.getStringExtra(CrearTarea.EXTRA_REPLY);

        SQLiteDatabase db = taskHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, nombre);
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
        updateUI();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Boton menu crear tarea
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, CrearTarea.class);
        startActivity(intent);
        return true;
    }

    //Tarea completada
    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.title_task);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = taskHelper.getWritableDatabase();
        db.delete(TaskContract.TaskEntry.TABLE, TaskContract.TaskEntry.COL_TASK_TITLE + " = ?", new String[]{task});
        db.close();
        updateUI();
    }

    public void launchInfo(View view) {
        Intent intent = new Intent(this, InfoTareas.class);
        startActivity(intent);
    }

    public void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = taskHelper.getReadableDatabase();
        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
            taskList.add(cursor.getString(idx));
        }

        if (arrAdapter == null) {
            arrAdapter = new ArrayAdapter<>(this, R.layout.todo_task, R.id.title_task, taskList);
            TaskList.setAdapter(arrAdapter);
        } else {
            arrAdapter.clear();
            arrAdapter.addAll(taskList);
            arrAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }
}