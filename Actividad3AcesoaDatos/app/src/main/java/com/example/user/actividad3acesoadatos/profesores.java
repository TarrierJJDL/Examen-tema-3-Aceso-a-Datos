package com.example.user.actividad3acesoadatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class profesores extends AppCompatActivity {
    private MyDBAdapter dbAdapter;
    EditText nombre, edad, ciclo, curso, despacho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        nombre = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);
        ciclo = (EditText) findViewById(R.id.ciclo);
        curso = (EditText) findViewById(R.id.curso);
        despacho = (EditText) findViewById(R.id.despacho);
        dbAdapter = new MyDBAdapter(this);
        final Button guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String nom = nombre.getText().toString();
                int ed;
                try {
                    ed = Integer.parseInt(edad.getText().toString());
                } catch (NumberFormatException nfe) {
                    ed = 0;
                }
                String ci = ciclo.getText().toString();
                String cur = curso.getText().toString();
                String des = despacho.getText().toString();

                dbAdapter.open();

                dbAdapter.insertarProfesores(nom,ed,ci,cur,des);


            }
        });
    }
}
