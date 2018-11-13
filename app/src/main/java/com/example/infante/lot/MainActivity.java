package com.example.infante.lot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button menu_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu_1 = findViewById(R.id.btn_menu_1);

        menu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent botonRegistro = new Intent(MainActivity.this, Registros.class);
                startActivity(botonRegistro);
            }
        });
    }
}
