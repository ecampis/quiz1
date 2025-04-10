package com.example.quiz1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt_Nombre;
    EditText edt_Edad;
    Spinner sp_categoria;
    Button btn_Guardar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_Nombre = findViewById(R.id.edt_Nombre);
        edt_Edad = findViewById(R.id.edt_Edad);
        sp_categoria = findViewById(R.id.sp_categoria);
        btn_Guardar = findViewById(R.id.btn_Guardar);

        String[] categorias = {"Deportes", "Música", "Cine"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        sp_categoria.setAdapter(adapter);

        btn_Guardar.setOnClickListener(v -> GuardarDatos());
    }

    private void GuardarDatos() {
        String nombre = edt_Nombre.getText().toString();
        String edad = edt_Edad.getText().toString();
        String categoria = sp_categoria.getSelectedItem().toString();

        SharedPreferences prefs = getSharedPreferences("datos_usuario", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("nombre", nombre);
        editor.putString("edad", edad);
        editor.putString("categoria", categoria);
        editor.apply();



        Intent intent = new Intent(this, Mostrar.class);
        startActivity(intent);










    }
}