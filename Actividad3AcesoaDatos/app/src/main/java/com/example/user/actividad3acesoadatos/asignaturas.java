package com.example.user.actividad3acesoadatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class asignaturas extends AppCompatActivity {

    private MyDBAdapter dbAdapter;

    TextView textView5;

    EditText nombre, edad, ciclo, inser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        nombre = (EditText) findViewById(R.id.nombre);
        inser = (EditText) findViewById(R.id.inser);
        edad = (EditText) findViewById(R.id.edad);
        ciclo = (EditText) findViewById(R.id.ciclo);
         textView5 = (TextView) this.findViewById(R.id.textView5);
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
                dbAdapter.open();

                dbAdapter.insertarAsignaturas(n,e,c);
            }
        });

        final Button buscar = (Button) findViewById(R.id.buscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String n = inser.getText().toString();
                dbAdapter.asignatura(n);
                ArrayList<String> gen =  dbAdapter.asignatura(n);
                textView5.setText(gen.get(0));


            }
        });

    }
}
