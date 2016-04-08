package com.ikerman.myapplication;

/**
 * Created by widemos on 25/2/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GestorBD {

    private SQLiteDatabase bd = null;
    private BDHelper helper = null;

    public GestorBD(Context context) {
        helper = new BDHelper(context, "Personas.sqlite", null, 1);
    }

    public void abrirBD() {
        if (bd == null)
            bd = helper.getWritableDatabase();
    }

    public void cerrarBD() {
        if (bd != null)
            bd.close();
    }

    public void guardarPersona(Ruta p) {
        if (bd.isOpen() && p != null) {

            ContentValues values = new ContentValues();

            values.put("d1", p.getD1());
            values.put("d2", p.getD2());

            bd.insert("Rutas", null, values);
        }
    }

    public void borrarRuta(Ruta p) {
        if (bd.isOpen() && p != null) {

            String tabla = "Rutas";
            String where = "id = ?";
            //String[] argumentoswhere = new String[]{p.getId()};
            //bd.delete(tabla, where, argumentoswhere);
        }
    }

    public Ruta leerRuta(int id) {

        Ruta p = null;

        if (bd.isOpen()) {

            String tabla = "ruta";
            String[] columnas = new String[]{"id", "d1", "d2","hora","min","segundos","dia","mes","año"};
            String where = "id = ?";
            String[] argumentoswhere = new String[]{String.valueOf(id)};
            String groupby = null;
            String having = null;
            String orderby = null;
            String limit = null;

            Cursor c1 = bd.query(tabla, columnas, where, argumentoswhere,
                    groupby, having, orderby, limit);

            if (c1.moveToFirst()) {
                p = new Ruta();
                p.setId(c1.getInt(1));
                p.setRutax(c1.getDouble[](2));
                p.setRutay(c1.getDouble(3));
                p.setHora(c1.getInt(4));
                p.setMin(c1.getInt(5));
                p.setSegundos(c1.getInt(6));
                p.setDia(c1.getInt(7));
                p.setMes(c1.getInt(8));
                p.setAño(c1.getInt(9));
            }
        }

        return p;
    }

    public List<Ruta> leerRutas() {

        List<Ruta> l = new ArrayList<>();

        if (bd.isOpen()) {

            String tabla = "personas";
            String[] columnas = new String[]{"id", "d1", "d2","hora","min","segundos","dia","mes","año"};
            String where = null; // "id = ?"
            String[] argumentoswhere = null; // = new String[] {"35"};
            String groupby = null;
            String having = null;
            String orderby = null;
            String limit = null;

            Cursor c1 = bd.query(tabla, columnas, where, argumentoswhere,
                    groupby, having, orderby, limit);

            if (c1.moveToFirst()) {

                // Recorremos el cursor hasta que no haya más registros
                do {
                    Ruta p = new Ruta(c1.getString(1), c1.getString(2));   // El campo 0 es el ID
                    l.add(p);
                } while (c1.moveToNext());
            }
        }

        return l;
    }

    private class BDHelper extends SQLiteOpenHelper {

        private String tablaRutas = "CREATE TABLE rutas ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nombre TEXT, apellidos TEXT );";

        public BDHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            if (!db.isReadOnly()) {
                // Enable foreign key constraints
                db.execSQL("PRAGMA foreign_keys=ON;");
                db.execSQL(tablaRutas);
            }

        }

        //@Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            if (!db.isReadOnly()) {
                db.execSQL("DROP TABLE IF EXISTS Rutas");

                // Enable foreign key constraints
                db.execSQL("PRAGMA foreign_keys=ON;");
                db.execSQL(tablaRutas);
            }
        }

    }

}