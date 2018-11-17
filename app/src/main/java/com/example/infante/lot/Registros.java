package com.example.infante.lot;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import util.Conexion;
import util.Utilidades;

public class Registros extends AppCompatActivity {
    ArrayList<String> lista_loterias;
//    ArrayList<String> loterias;
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

        obtenerLoterias();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista_loterias);
        selecion_loteria.setAdapter(adaptador);
    }


    public void onClick(View view){
        registrarSorteo();
    }

    private void obtenerLoterias(){
//        Conexion conn = new Conexion(this, "loteria", null, 1);
//        SQLiteDatabase ddbb = conn.getReadableDatabase();

        lista_loterias = new ArrayList<>();
        lista_loterias.add("Elige un sorteo.");
        lista_loterias.add("Loteria Nacional");
        lista_loterias.add("Loteka");
        lista_loterias.add("Loteria Real");

//        Cursor cursor = ddbb.rawQuery("SHOW TABLE FROM loteria", null);
//        while (cursor.moveToNext()){
//            lista_loterias.add(cursor.toString());
//        }
//        loterias = new ArrayList<>();
//
//


    }

    private void registrarSorteo(){
        String sorteo = selecion_loteria.getSelectedItem().toString();//obtener la loteria seleccionada en el spinner
        Date fecha = Calendar.getInstance().getTime();

        Conexion conexion = new Conexion(this, "loteria", null, 1);

        SQLiteDatabase db = conexion.getReadableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(Utilidades.ID, fecha.toString());
        valores.put(Utilidades.PRIMERO, primer_premio.getText().toString());
        valores.put(Utilidades.SEGUNDO, segundo_premio.getText().toString());
        valores.put(Utilidades.TERCERO, tercer_premio.getText().toString());

        if(sorteo == "Loteria Nacional"){
            db.insert(Utilidades.TABLA_NACIONAL, Utilidades.ID, valores);
            limpiarCampos();
        } else if (sorteo == "Loteka") {
            db.insert(Utilidades.TABLA_LOTEKA,Utilidades.ID, valores);
            limpiarCampos();
        }else if(sorteo == "Loteria Real"){
            db.insert(Utilidades.TABLA_REAL,Utilidades.ID, valores);
            limpiarCampos();
        }else{
            Toast.makeText(this, "No seleccionaste un sorteo.", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }

    private void limpiarCampos() {
        primer_premio.setText("");
        segundo_premio.setText("");
        tercer_premio.setText("");
        primer_premio.requestFocus();
    }

}
