package com.example.mistareas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mistareas2.task_database.TaskContract;
import com.example.mistareas2.task_database.TaskDatabaseHelper;

import java.util.ArrayList;

public class CrearTarea extends AppCompatActivity {
    public static final String EXTRA_REPLY ="com.example.android.mistareas2.extra.MESSAGE";
    private EditText mNombre;
    private EditText mReply;

    private TaskDatabaseHelper taskHelper;
    private ListView TaskList;
    private ArrayAdapter<String> arrAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tarea);
        mNombre = findViewById(R.id.Texto_Nombre);
        Intent intent = getIntent();



//        String task = String.valueOf(mReply.getText());
//        SQLiteDatabase db = taskHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
//        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
//        db.close();
//        updateUI();


    }

    public void launchTareaCreada(View view) {
        String nombre = mNombre.getText().toString();
        Intent replyIntent = new Intent();
        setResult(RESULT_OK,replyIntent);
        finish();



    }
//
//    public void returnReply(View view) {
//        String reply = mReply.getText().toString();
//        Intent replyIntent = new Intent();
//        replyIntent.putExtra(EXTRA_MESSAGE, reply);
//        setResult(RESULT_OK,replyIntent);
//        finish();
//
//
//    }
//
//    private void updateUI() {
//        ArrayList<String> taskList = new ArrayList<>();
//        SQLiteDatabase db = taskHelper.getReadableDatabase();
//        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
//                new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE},
//                null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            int idx = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
//            taskList.add(cursor.getString(idx));
//        }
//
//        if (arrAdapter == null) {
//            arrAdapter = new ArrayAdapter<>(this, R.layout.todo_task, R.id.title_task, taskList);
//            TaskList.setAdapter(arrAdapter);
//        } else {
//            arrAdapter.clear();
//            arrAdapter.addAll(taskList);
//            arrAdapter.notifyDataSetChanged();
//        }
//
//        cursor.close();
//        db.close();
//    }

}