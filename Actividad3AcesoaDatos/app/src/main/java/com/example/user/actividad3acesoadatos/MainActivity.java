package com.example.user.actividad3acesoadatos;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS ="My preferences";
    EditText nombre, usuario, fecha;
    CheckBox hombre, mujer;
    final int Main2Activity=1;
    final int Alumnos=2;
    final int Profesores=3;
    final int consult=4;
    final int asige=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        usuario = (EditText) findViewById(R.id.usuario);
        fecha = (EditText) findViewById(R.id.fecha);
        hombre = (CheckBox) findViewById(R.id.hombre);
        mujer = (CheckBox) findViewById(R.id.mujer);

        final Button guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);

                SharedPreferences Shared = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
                SharedPreferences.Editor edi = Shared.edit();

                String nom = nombre.getText().toString();
                String us = usuario.getText().toString();
                String fec = fecha.getText().toString();

                edi.putString("Nombre",nom);
                edi.putString("Usuario",us);
                edi.putString("Fecha",fec);

                if (hombre.isChecked()) {
                    edi.putString("Sexo", "Hombre");
                }
                if (mujer.isChecked()) {
                    edi.putString("Sexo", "Mujer");
                }

                else {
                    edi.putString("Sexo", "Indeciso");
                }

                edi.commit();
                startActivityForResult(i,Main2Activity);


            }
        });

        final Button alumnos = (Button) findViewById(R.id.alumnos);
        alumnos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), alumnos.class);
                startActivityForResult(i, Alumnos);
            }
        });
        final Button profesores = (Button) findViewById(R.id.profesores);
        profesores.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), profesores.class);
                startActivityForResult(i, Profesores);
            }
        });

        final Button consultas = (Button) findViewById(R.id.consultas);
        consultas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Consultas.class);
                startActivityForResult(i, consult);
            }
        });
        final Button asig = (Button) findViewById(R.id.asig);
        asig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), asignaturas.class);
                startActivityForResult(i, asige);
            }
        });
    }


}
