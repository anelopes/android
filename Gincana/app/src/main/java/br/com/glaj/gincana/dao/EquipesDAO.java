package br.com.glaj.gincana.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.glaj.gincana.modelo.Equipes;

/**
 * Created by Anelise on 06/09/2017.
 */

public class EquipesDAO extends SQLiteOpenHelper {

    public EquipesDAO(Context context) {
        super(context, "Equipes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Equipes (id INTEGER PRIMARY KEY, nome TEXT NOT NULL);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS Equipes";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Equipes equipes) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDaEquipe(equipes);

        db.insert("Equipes", null, dados);
    }
    private ContentValues pegaDadosDaEquipe(Equipes equipes){
        ContentValues dados = new ContentValues();
        dados.put("nome",equipes.getNome());
        return dados;

    }


    public List<Equipes> buscaEquipe() {
        String sql = "SELECT * FROM Equipes;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Equipes> cores = new ArrayList<Equipes>();
        while(c.moveToNext()){
            Equipes equipes = new Equipes();
            equipes.setId(c.getLong(c.getColumnIndex("id")));
            equipes.setNome(c.getString(c.getColumnIndex("nome")));

            cores.add(equipes);
        }
        c.close();
        return cores;
    }

    public void deleta(Equipes equipes) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {equipes.getId().toString()};
        db.delete("Equipes" , "id = ?", params);
    }
}
