package br.com.glaj.gincana.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.glaj.gincana.modelo.Cadastro;

/**
 * Created by Anelise on 24/08/2017.
 */

public class CadastroDAO extends SQLiteOpenHelper {

    private Cadastro cadastro;

    public CadastroDAO(Context context) {
        super(context, "Gincana", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Cadastro (id INTEGER PRIMARY KEY," +
                " nome TEXT NOT NULL," +
                " usuario TEXT NOT NULL," +
                " senha TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Cadastro";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Cadastro cadastro) {
        SQLiteDatabase db = getWritableDatabase(); // referencia que possa escrever

        ContentValues dados = pegaDadosDoCadastro(cadastro);

        db.insert("Cadastro", null, dados);

    }

    public ContentValues pegaDadosDoCadastro(Cadastro cadastro) { // chave e valor
        ContentValues dados = new ContentValues();
        dados.put("nome", cadastro.getNome());
        dados.put("usuario", cadastro.getUsuario());
        dados.put("senha", cadastro.getSenha());
        return dados;
    }

    public List<Cadastro> buscaCadastro() {
        String sql = "SELECT * FROM Cadastro;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null); //devolve um cursor

        List<Cadastro> cadastros = new ArrayList<Cadastro>();
        while (c.moveToNext()) {
            Cadastro cadastro = new Cadastro();
            cadastro.setId(c.getLong(c.getColumnIndex("id")));
            cadastro.setNome(c.getString(c.getColumnIndex("nome")));
            cadastro.setUsuario(c.getString(c.getColumnIndex("usuario")));
            cadastro.setSenha(c.getString(c.getColumnIndex("senha")));

            cadastros.add(cadastro);
        }
        c.close();
        return cadastros;
}

    public void deleta(Cadastro cadastro) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {cadastro.getId().toString()};
        db.delete("Cadastro", "id = ?", params);
    }

    public boolean isUserValid(Cadastro user) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select usuario, senha from Cadastro where usuario=? and senha=?";
        Cursor c = db.rawQuery(sql, null);

        ArrayList<Cadastro> users = new ArrayList<>();


        boolean isUserValid = false;

        if(c.moveToNext()){
            user.setUsuario(c.getString(c.getColumnIndex("usuario")));
            user.setSenha(c.getString(c.getColumnIndex("senha")));
            users.add(user);
            isUserValid = true;
        }
        c.close();
        db.close();
        return isUserValid;
    }
}
