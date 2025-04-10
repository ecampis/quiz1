package com.example.quiz1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Mostrar extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("datos_usuario", MODE_PRIVATE);
        String nombre = prefs.getString("nombre", "");
        String edad = prefs.getString("edad", "");
        String categoria = prefs.getString("categoria", "");


        switch (categoria) {
            case "Deportes":
                setContentView(R.layout.activity_deportes);
                break;
            case "Música":
                setContentView(R.layout.activity_musica);
                break;
            case "Cine":
                setContentView(R.layout.activity_cine);
                break;
        }

        TextView tvInfo = findViewById(R.id.tvInfo);
        tvInfo.setText("Nombre: " + nombre + "\nEdad: " + edad + "\nCategoría: " + categoria);
    }
}
