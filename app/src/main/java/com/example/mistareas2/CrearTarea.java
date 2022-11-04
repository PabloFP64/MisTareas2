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
    public static final String EXTRA_REPLY ="com.example.android.mistareas2.extra.REPLY";
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




    }

    public void launchTareaCreada(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        String nombre = mNombre.getText().toString();
        intent.putExtra(EXTRA_REPLY, nombre);
        //setResult(RESULT_OK,intent);
        startActivity(intent);



    }


}