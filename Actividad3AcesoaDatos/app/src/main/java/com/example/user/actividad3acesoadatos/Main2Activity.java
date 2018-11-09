package com.example.user.actividad3acesoadatos;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.user.actividad3acesoadatos.MainActivity.PREFS;

public class Main2Activity extends AppCompatActivity {

    TextView nombre2, usuario2, fecha2, sexo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nombre2 = (TextView) findViewById(R.id.nombre2);
        usuario2 = (TextView) findViewById(R.id.usuario2);
        fecha2 = (TextView) findViewById(R.id.fecha2);
        sexo2 = (TextView) findViewById(R.id.sexo2);
        SharedPreferences Shared = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);


        String nom = Shared.getString("Nombre","");
        String us = Shared.getString("Usuario","");
        String fec = Shared.getString("Fecha","");
        String sexo = Shared.getString("Sexo","");
        nombre2.setText(nom);
        usuario2.setText(us);
        fecha2.setText(fec);
        sexo2.setText(sexo);
    }
}
