package com.example.user.actividad3acesoadatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Consultas extends AppCompatActivity {

    private MyDBAdapter dbAdapter;
   TextView textView, textView2,textView3, textView4, textView5;
   Button todosalumnos, estciclo, estcurso, todosprofes, profyal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        textView = (TextView) this.findViewById(R.id.textView);
        textView2 = (TextView) this.findViewById(R.id.textView2);
        textView3 = (TextView) this.findViewById(R.id.textView3);
        textView4 = (TextView) this.findViewById(R.id.textView4);
        textView5 = (TextView) this.findViewById(R.id.textView5);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();


        todosalumnos = (Button) findViewById(R.id.todosalumnos);
       todosalumnos.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dbAdapter.open();

               ArrayList<String> gen = dbAdapter.todosAlumnos();
               textView.setText(gen.get(0));
               textView2.setText(gen.get(1));
               textView3.setText(gen.get(2));
               textView4.setText(gen.get(3));
               textView5.setText(gen.get(4));
           }
       });
        estciclo = (Button) findViewById(R.id.estciclo);
        estciclo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                dbAdapter.open();

                ArrayList<String> gen = dbAdapter.AlumnosCiclo();
                textView.setText(gen.get(0));
                textView2.setText(gen.get(1));
                textView3.setText(gen.get(2));
                textView4.setText(gen.get(3));
                textView5.setText(gen.get(4));
            }
        });
        estcurso = (Button) findViewById(R.id.estcurso);
        estcurso.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dbAdapter.open();

                ArrayList<String> gen = dbAdapter.AlumnosCurso();
                textView.setText(gen.get(0));
                textView2.setText(gen.get(1));
                textView3.setText(gen.get(2));
                textView4.setText(gen.get(3));
                textView5.setText(gen.get(4));
            }
        });
        todosprofes = (Button) findViewById(R.id.todosprofes);
        todosprofes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dbAdapter.open();

                ArrayList<String> gen = dbAdapter.todosPrfes();
                textView.setText(gen.get(0));
                textView2.setText(gen.get(1));
                textView3.setText(gen.get(2));
                textView4.setText(gen.get(3));
                textView5.setText(gen.get(4));
            }
        });
        profyal = (Button) findViewById(R.id.profyal);
        profyal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dbAdapter.open();

                ArrayList<String> gen = dbAdapter.Profyal();
                textView.setText(gen.get(0));
                textView2.setText(gen.get(1));
                textView3.setText(gen.get(2));
                textView4.setText(gen.get(3));
                textView5.setText(gen.get(4));
            }
        });


    }
}
