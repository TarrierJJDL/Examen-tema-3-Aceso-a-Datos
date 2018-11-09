package com.example.user.actividad3acesoadatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;


public class MyDBAdapter {

    private static final String DATABASE_NAME = "inst.db";
    private static final String DATABASE_TABLE = "estudiantes";
    private static final String DATABASE_TABLE2 = "profesores";
    private static final String DATABASE_TABLE3 = "asignaturas";
    private static final int DATABASE_VERSION = 1;

    private static final String A_NOMBRE = "nombre";
    private static final String A_EDAD = "edad";
    private static final String A_CICLO = "ciclo";
    private static final String A_CURSO = "curso";
    private static final String A_NOTAM = "notamedia";

    private static final String AS_ID = "id";
    private static final String AS_NOMBRE = "nombre";
    private static final String AS_AL = "matri";

    private static final String P_NOMBRE = "nombre";
    private static final String P_EDAD = "edad";
    private static final String P_CICLO = "ciclo";
    private static final String P_CURSO = "curso";
    private static final String P_DESP = "despacho";



    private static final String DATABASE_CREATE = "CREATE TABLE "+DATABASE_TABLE+" (_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, notamedia text);";
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS "+DATABASE_TABLE+";";


    private static final String DATABASE_CREATE2 = "CREATE TABLE "+DATABASE_TABLE2+" (_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, despacho text);";
    private static final String DATABASE_DROP2 = "DROP TABLE IF EXISTS "+DATABASE_TABLE2+";";

    private static final String DATABASE_CREATE3 = "CREATE TABLE "+DATABASE_TABLE3+" (_id integer primary key autoincrement, id text, nombre text, matri integer);";
    private static final String DATABASE_DROP3 = "DROP TABLE IF EXISTS "+DATABASE_TABLE3+";";

    private final Context context;
    private MyDbHelper dbHelper;
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public boolean insertarAlumno(String n, int e, String c, String cur, String not){
        int i=0; boolean h=false;
        ContentValues newValues = new ContentValues();

        newValues.put(A_NOMBRE,n);
        newValues.put(A_EDAD,e);
        newValues.put(A_CICLO,c);
        newValues.put(A_CURSO,cur);
        newValues.put(A_NOTAM,not);

        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){

            do{

                String u;
                u=cursor.getString(1);
                if(n==u){
                    i++;
                }

                }while (cursor.moveToNext());

        }
        if (i==0){
            db.insert(DATABASE_TABLE,null,newValues);
        }
        else {
            h=true;
        }
        return h;


    }


    public void insertarProfesores(String y, int t, String r, String o, String des){

        ContentValues neValues = new ContentValues();

        neValues.put(P_NOMBRE,y);
        neValues.put(P_EDAD,t);
        neValues.put(P_CICLO,r);
        neValues.put(P_CURSO,o);
        neValues.put(P_DESP,des);



        db.insert(DATABASE_TABLE2,null,neValues);
    }

    public void insertarAsignaturas(String y, int t, String r){

        ContentValues nValues = new ContentValues();

        nValues.put(AS_ID,y);
        nValues.put(AS_AL,t);
        nValues.put(A_NOMBRE,r);

        db.insert(DATABASE_TABLE3,null,nValues);
    }

    public ArrayList<String> asignatura(String n){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE3,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){

            do{
                String u;
                u=cursor.getString(2);
                if(u==n){
                    gen.add(cursor.getString(3));}

            }while (cursor.moveToNext());
        }
        return gen;
    }


    public ArrayList<String> todosAlumnos(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){

            do{
                int u;
                u=cursor.getInt(2);
                if(u<25||u>20){
                gen.add(cursor.getString(1)+" "+cursor.getInt(2));}

            }while (cursor.moveToNext());
        }
        return gen;
    }

    public ArrayList<String> AlumnosCiclo(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                gen.add(cursor.getString(1)+" "+cursor.getString(3));
            }while (cursor.moveToNext());
        }
        return gen;
    }

    public ArrayList<String> AlumnosCurso(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                gen.add(cursor.getString(1)+" "+cursor.getString(4));
            }while (cursor.moveToNext());
        }
        return gen;
    }

    public ArrayList<String> todosPrfes(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                gen.add(cursor.getString(6)+" "+cursor.getString(7)+" "+cursor.getString(8)+" "+cursor.getString(9)+" "+cursor.getString(10));
            }while (cursor.moveToNext());
        }
        return gen;
    }
    public ArrayList<String> Profyal(){
        ArrayList<String> gen = new ArrayList<String>();
        Cursor cursor = db.query(DATABASE_TABLE,null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do{
                gen.add(cursor.getString(1)+" "+cursor.getLong(2));
            }while (cursor.moveToNext());
        }
        return gen;
    }

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE2);
            db.execSQL(DATABASE_CREATE3);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            db.execSQL(DATABASE_DROP2);
            db.execSQL(DATABASE_DROP3);
            onCreate(db);
        }



    }
}

