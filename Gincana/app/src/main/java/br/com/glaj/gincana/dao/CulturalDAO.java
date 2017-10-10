package br.com.glaj.gincana.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.glaj.gincana.modelo.Cadastro;
import br.com.glaj.gincana.modelo.Cultural;

/**
 * Created by Anelise on 05/09/2017.
 */

public class CulturalDAO extends SQLiteOpenHelper {

    public CulturalDAO(Context context) {
        super(context, "Cultural", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Cultural (id INTEGER PRIMARY KEY, nome TEXT NOT NULL);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS Cultural";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Cultural cultural) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDaCultural(cultural);

        db.insert("Cultural", null, dados);
    }

    private ContentValues pegaDadosDaCultural(Cultural cultural) {
        ContentValues dados = new ContentValues();
        dados.put("nome", cultural.getNome());
        return dados;
    }

    public List<Cultural> buscaProva() {
        String sql = "SELECT * FROM Cultural;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null); //devolve um cursor

        List<Cultural> provas = new ArrayList<Cultural>();
        while (c.moveToNext()){
            Cultural cultural = new Cultural();
            cultural.setId(c.getLong(c.getColumnIndex("id")));
            cultural.setNome(c.getString(c.getColumnIndex("nome")));

            provas.add(cultural);
        }
        c.close();
        return provas;
    }
}
