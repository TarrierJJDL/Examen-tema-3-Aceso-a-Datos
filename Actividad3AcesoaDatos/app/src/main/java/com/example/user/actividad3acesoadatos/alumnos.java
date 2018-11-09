package com.example.user.actividad3acesoadatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class alumnos extends AppCompatActivity {

    private MyDBAdapter dbAdapter;

    EditText nombre, edad, ciclo, curso, nota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        nombre = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.edad);
        ciclo = (EditText) findViewById(R.id.ciclo);
        curso = (EditText) findViewById(R.id.curso);
        nota = (EditText) findViewById(R.id.nota);
        dbAdapter = new MyDBAdapter(this);
        final Button guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String n = nombre.getText().toString();
                int e;
                try {
                    e = Integer.parseInt(edad.getText().toString());
                } catch (NumberFormatException nfe) {
                    e = 0;
                }
                String c = ciclo.getText().toString();
                String cu = curso.getText().toString();
                String not = nota.getText().toString();





                dbAdapter.open();

                dbAdapter.insertarAlumno(n,e,c,cu,not);
               boolean h = dbAdapter.insertarAlumno(n,e,c,cu,not);

                if(h==true){
                    Toast.makeText(alumnos.this, "No se ha podido insertar", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
