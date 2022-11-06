package com.example.mistareas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoTareas extends AppCompatActivity {

    private TextView mNombre;
    private TextView mDescripcion;
    private TextView mFecha;
    private TextView mUrgencia;
    private TextView mPrecio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tareas);

        mNombre = findViewById(R.id.textoNombre);
        mDescripcion = findViewById(R.id.textoDescripcion);
        mFecha = findViewById(R.id.textoFecha);
        mUrgencia = findViewById(R.id.textoUrgencia);
        mPrecio = findViewById(R.id.textoPrecio);

        Intent intent = getIntent();

        String nombre = intent.getStringExtra(CrearTarea.EXTRA_REPLY_N);

        CrearInfo(nombre);
    }

    private void CrearInfo(String nombre) {
        Tarea tarea = new Tarea();
        String a = "AAAAAAAAAAAAAAA";
        mNombre.setText(a);
        mDescripcion.setText(a);
        mFecha.setText(a);
        mUrgencia.setText(a);
        mPrecio.setText(a);
//        mNombre.setText(tarea.getNombre());
//        mDescripcion.setText(tarea.getDescripcion());
//        mFecha.setText(tarea.getFecha());
//        mUrgencia.setText(tarea.getPrioridad());
//        mPrecio.setText(tarea.getCoste());
    }

    public void cancelarInfo(View view) {
        finish();
    }


}



