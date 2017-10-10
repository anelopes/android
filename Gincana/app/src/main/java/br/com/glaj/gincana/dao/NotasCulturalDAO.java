package br.com.glaj.gincana.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.glaj.gincana.modelo.NotasCultural;

/**
 * Created by Anelise on 14/09/2017.
 */

public class NotasCulturalDAO extends SQLiteOpenHelper {


    public NotasCulturalDAO(Context context) {
        super(context, "NotasCultural", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE NotasCultural (id INTEGER PRIMARY KEY," +
                " professor TEXT NOT NULL, " +
                "sala TEXT NOT NULL, " +
                "prova TEXT NOT NULL, " +
                "nota DOUBLE NOT NULL);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS NotasCultural";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(NotasCultural notasCultural) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosdaNotaCultural(notasCultural);

        db.insert("NotasCultural", null, dados);
    }

    private ContentValues pegaDadosdaNotaCultural(NotasCultural notasCultural) {
        ContentValues dados = new ContentValues();
        dados.put("professor", notasCultural.getProfessor());
        dados.put("sala", notasCultural.getSala());
        dados.put("prova", notasCultural.getProva());
        dados.put("nota", notasCultural.getNota());
        return dados;
    }
}
