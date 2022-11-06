package com.example.mistareas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mistareas2.task_database.TaskDatabaseHelper;

public class CrearTarea extends AppCompatActivity {
    public static final String EXTRA_REPLY_N ="com.example.android.mistareas2.extra.REPLY";
    public static final String EXTRA_REPLY_C ="com.example.android.mistareas2.extra.REPLY_C";
    public static final String EXTRA_REPLY_F ="com.example.android.mistareas2.extra.REPLY_F";
    public static final String EXTRA_REPLY_P ="com.example.android.mistareas2.extra.REPLY_P";
    public static final String EXTRA_REPLY_D ="com.example.android.mistareas2.extra.REPLY_D";
    private EditText mNombre;
    private EditText mCoste;
    private EditText mFecha;
    private EditText mPrioridad;
    private EditText mDescripcion;





    private TaskDatabaseHelper taskHelper;
    private ListView TaskList;
    private ArrayAdapter<String> arrAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tarea);

        mNombre = findViewById(R.id.Texto_Nombre);
        mCoste = findViewById(R.id.Texto_Coste);
        mFecha = findViewById(R.id.Texto_Fecha);
        mPrioridad = findViewById(R.id.Texto_Prioridad);
        mDescripcion = findViewById(R.id.Texto_Descrip);
    }

    @Override
    public void onBackPressed(){

    }

    public void launchTareaCreada(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        String nombre = mNombre.getText().toString();
        String coste = mCoste.getText().toString();
        String fecha = mFecha.getText().toString();
        String prioridad = mPrioridad.getText().toString();
        String descripcion = mDescripcion.getText().toString();


        intent.putExtra(EXTRA_REPLY_N, nombre);
        intent.putExtra(EXTRA_REPLY_C, coste);
        intent.putExtra(EXTRA_REPLY_F, fecha);
        intent.putExtra(EXTRA_REPLY_P, prioridad);
        intent.putExtra(EXTRA_REPLY_D, descripcion);
        //setResult(RESULT_OK,intent);
        startActivity(intent);

    }


    public void cancelarTarea(View view) {
        finish();
    }
}