package com.example.infante.lot;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import util.Conexion;
import util.Utilidades;

public class Registros extends AppCompatActivity {
    Button btn_guardar;
    Spinner selecion_loteria;
    EditText primer_premio;
    EditText segundo_premio;
    EditText tercer_premio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_layout);

        btn_guardar = findViewById(R.id.btn_guardar);
        selecion_loteria = findViewById(R.id.spinner_elige_lot);
        primer_premio = findViewById(R.id.txt_primero);
        segundo_premio = findViewById(R.id.txt_segundo);
        tercer_premio = findViewById(R.id.txt_tercero);
    }
    public void onClick(View view){
        registrarSorteo();
    }

    private void registrarSorteo(){

        Date fecha = Calendar.getInstance().getTime();



        Conexion conexion = new Conexion(this, "loteria", null, 1);

        SQLiteDatabase db = conexion.getReadableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(Utilidades.ID, fecha.toString());
        valores.put(Utilidades.PRIMERO, primer_premio.getText().toString());
        valores.put(Utilidades.SEGUNDO, segundo_premio.getText().toString());
        valores.put(Utilidades.TERCERO, tercer_premio.getText().toString());

        db.insert(Utilidades.NOMBRE_TABLA, Utilidades.ID, valores);

        db.close();

        primer_premio.setText("");
        segundo_premio.setText("");
        tercer_premio.setText("");


    }

}
