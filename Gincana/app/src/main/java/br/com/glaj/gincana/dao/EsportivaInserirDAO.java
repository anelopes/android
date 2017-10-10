package br.com.glaj.gincana.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.glaj.gincana.modelo.EsportivaInserir;

/**
 * Created by Anelise on 11/09/2017.
 */

public class EsportivaInserirDAO extends SQLiteOpenHelper {

    public EsportivaInserirDAO(Context context) {
        super(context, "EsportivaInserir", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE EsportivaInserir (id INTEGER PRIMARY KEY, nome TEXT NOT NULL);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS EsportivaInserir";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(EsportivaInserir esportivaInserir) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDaEsportivaInserir(esportivaInserir);

        db.insert("EsportivaInserir", null, dados);
    }

    private ContentValues pegaDadosDaEsportivaInserir(EsportivaInserir esportivaInserir) {
        ContentValues dados = new ContentValues();
        dados.put("nome", esportivaInserir.getNome());
        return dados;
    }

    public List<EsportivaInserir> buscaProva() {
        String sql="SELECT * FROM EsportivaInserir;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<EsportivaInserir> provas = new ArrayList<EsportivaInserir>();

        while (c.moveToNext()){
            EsportivaInserir esportivaInserir = new EsportivaInserir();
            esportivaInserir.setId(c.getLong(c.getColumnIndex("id")));
            esportivaInserir.setNome(c.getString(c.getColumnIndex("nome")));

            provas.add(esportivaInserir);
        }

        c.close();
        return provas;
    }
}
