package com.example.fairticket;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        crearDB();
    }

    private void crearDB() {
        TablasSQL tablasObj = new TablasSQL(this);
        final SQLiteDatabase db = tablasObj.getWritableDatabase();

        /*
        Sortu XML bat datu batzukin.
        Defektuzko datuak izateko.

        Batzuk betiko utzita ta beste batzuk probetako.

        Eredu bezala VisualStudion SilentComerciales en aplikazioa ireki.
         */
    }
}
