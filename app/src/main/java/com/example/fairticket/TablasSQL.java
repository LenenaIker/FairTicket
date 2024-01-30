package com.example.fairticket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TablasSQL extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FairTicket.db";

    public TablasSQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String sentenciaCrearTabla;

        // Crear tabla Cliente
        sentenciaCrearTabla = "CREATE TABLE Cliente (" +
                "id_cliente INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "apellido TEXT," +
                "telefono TEXT," +
                "correo TEXT," +
                "direccion TEXT" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Calidad
        sentenciaCrearTabla = "CREATE TABLE Calidad (" +
                "calidad_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT," +
                "precio_extra DOUBLE NOT NULL" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Factura
        sentenciaCrearTabla = "CREATE TABLE Factura (" +
                "factura_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "cliente_id INTEGER NOT NULL," +
                "fecha_factura DATE NOT NULL," +
                "FOREIGN KEY(cliente_id) REFERENCES Cliente(id_cliente)" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Entrada
        sentenciaCrearTabla = "CREATE TABLE Entrada (" +
                "entrada_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "evento_id INTEGER NOT NULL," +
                "calidad_id INTEGER NOT NULL," +
                "precio DOUBLE," +
                "stock INTEGER," +
                "descripcion TEXT," +
                "FOREIGN KEY(evento_id) REFERENCES Evento(evento_id)," +
                "FOREIGN KEY(calidad_id) REFERENCES Calidad(calidad_id)" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Organizador
        sentenciaCrearTabla = "CREATE TABLE Organizador (" +
                "organizador_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "descripcion TEXT," +
                "gerente_nombre TEXT," +
                "gerente_telefono TEXT," +
                "gerente_correo TEXT" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Evento
        sentenciaCrearTabla = "CREATE TABLE Evento (" +
                "evento_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "descripcion TEXT," +
                "fecha_inicio DATE," +
                "fecha_fin DATE," +
                "organizador_id INTEGER," +
                "FOREIGN KEY(organizador_id) REFERENCES Organizador(organizador_id)" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Linea
        sentenciaCrearTabla = "CREATE TABLE Linea (" +
                "factura_id INTEGER," +
                "entrada_id INTEGER," +
                "cantidad INTEGER," +
                "precio DOUBLE," +
                "PRIMARY KEY(factura_id, entrada_id)," +
                "FOREIGN KEY(factura_id) REFERENCES Factura(factura_id)," +
                "FOREIGN KEY(entrada_id) REFERENCES Entrada(entrada_id)" +
                ")";
        db.execSQL(sentenciaCrearTabla);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Futuras operaciones de actualización de la base de datos si cambia la versión
    }
}
