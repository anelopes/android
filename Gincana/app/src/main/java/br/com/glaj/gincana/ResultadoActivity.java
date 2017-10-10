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

import br.com.glaj.gincana.dao.EquipesDAO;
import br.com.glaj.gincana.modelo.Equipes;


public class ResultadoActivity extends AppCompatActivity {

    private ListView listaEquipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        carregaCores();
        registerForContextMenu(listaEquipes);

    }

    private void carregaCores() {
        EquipesDAO dao = new EquipesDAO(this);
        List<Equipes> cores = dao.buscaEquipe();
        dao.close();

        listaEquipes = (ListView) findViewById(R.id.lista_cores);

        ArrayAdapter<Equipes> adapterEquipes = new ArrayAdapter<Equipes>(this, android.R.layout.simple_list_item_1, cores);
        listaEquipes.setAdapter(adapterEquipes);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaCores();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Equipes equipes = (Equipes) listaEquipes.getItemAtPosition(info.position);

                EquipesDAO dao = new EquipesDAO(ResultadoActivity.this);
                dao.deleta(equipes);
                dao.close();

                carregaCores();
                return false;
            }
        });
    }
}
