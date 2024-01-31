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
                "id_cliente INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "usuario TEXT UNIQUE," +
                "clave TEXT NOT NULL," +
                "dni TEXT UNIQUE," +
                "nombre TEXT NOT NULL," +
                "apellidos TEXT NOT NULL," +
                "telefono TEXT UNIQUE," +
                "correo TEXT UNIQUE," +
                "direccion TEXT" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Calidad
        sentenciaCrearTabla = "CREATE TABLE Calidad (" +
                "id_calidad INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT," +
                "precio_extra REAL NOT NULL" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Factura
        sentenciaCrearTabla = "CREATE TABLE Factura (" +
                "id_factura INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "id_cliente INTEGER NOT NULL," +
                "fecha_factura DATE NOT NULL," +
                "FOREIGN KEY(id_cliente) REFERENCES Cliente(id_cliente)" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Entrada
        sentenciaCrearTabla = "CREATE TABLE Entrada (" +
                "id_entrada INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "id_evento INTEGER NOT NULL," +
                "id_calidad INTEGER NOT NULL," +
                "precio REAL NOT NULL," +
                "stock INTEGER NOT NULL," +
                "descripcion TEXT," +
                "FOREIGN KEY(id_evento) REFERENCES Evento(id_evento)," +
                "FOREIGN KEY(id_calidad) REFERENCES Calidad(id_calidad)" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Organizador
        sentenciaCrearTabla = "CREATE TABLE Organizador (" +
                "id_organizador INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT," +
                "gerente_nombre TEXT NOT NULL," +
                "gerente_telefono TEXT UNIQUE," +
                "gerente_correo TEXT UNIQUE" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Evento
        sentenciaCrearTabla = "CREATE TABLE Evento (" +
                "id_evento INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT," +
                "fecha_inicio DATE NOT NULL," +
                "fecha_fin DATE," +
                "id_organizador INTEGER," +
                "FOREIGN KEY(id_organizador) REFERENCES Organizador(id_organizador)" +
                ")";
        db.execSQL(sentenciaCrearTabla);

        // Crear tabla Linea
        sentenciaCrearTabla = "CREATE TABLE Linea (" +
                "id_linea INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "id_factura INTEGER NOT NULL," +
                "id_entrada INTEGER NOT NULL," +
                "cantidad INTEGER NOT NULL," +
                "FOREIGN KEY(id_factura) REFERENCES Factura(id_factura)," +
                "FOREIGN KEY(id_entrada) REFERENCES Entrada(id_entrada)" +
                ")";
        db.execSQL(sentenciaCrearTabla);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Futuras operaciones de actualización de la base de datos si cambia la versión
    }
}
