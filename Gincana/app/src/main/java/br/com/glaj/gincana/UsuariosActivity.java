package br.com.glaj.gincana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.glaj.gincana.dao.CadastroDAO;
import br.com.glaj.gincana.helper.CadastroHelper;
import br.com.glaj.gincana.modelo.Cadastro;

public class UsuariosActivity extends AppCompatActivity {


    private ListView listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        carregaUsuarios();
        registerForContextMenu(listaUsuarios);
    }

    private void carregaUsuarios() {
        CadastroDAO dao = new CadastroDAO(this);
        List<Cadastro> usuarios = dao.buscaCadastro();
        dao.close();

        listaUsuarios = (ListView) findViewById(R.id.lista_usuarios);

        ArrayAdapter<Cadastro> adapterUsuarios = new ArrayAdapter<Cadastro>(this, android.R.layout.simple_list_item_1, usuarios);
        listaUsuarios.setAdapter(adapterUsuarios);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaUsuarios();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Cadastro cadastro = (Cadastro) listaUsuarios.getItemAtPosition(info.position);

                CadastroDAO dao = new CadastroDAO(UsuariosActivity.this);
                dao.deleta(cadastro);
                dao.close();

                carregaUsuarios();
                return false;
            }
        });
    }
}
