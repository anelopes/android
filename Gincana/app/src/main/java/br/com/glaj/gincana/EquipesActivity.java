package br.com.glaj.gincana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.glaj.gincana.dao.EquipesDAO;
import br.com.glaj.gincana.helper.EquipesHelper;
import br.com.glaj.gincana.modelo.Equipes;

public class EquipesActivity extends AppCompatActivity {


    private EquipesHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes);

        //Sppiner de salas
        String[] salas = {"1ºA", "1ºB", "1ºC", "2ºA", "2ºB", "2ºC", "3ºA", "3ºB", "3ºC"};
        ArrayAdapter<String> adapterSalas = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, salas);

        Spinner sppinerSalas = (Spinner) findViewById(R.id.equipes_salas);
        sppinerSalas.setAdapter(adapterSalas);

        helper = new EquipesHelper(this);

        final Button equipes = (Button) findViewById(R.id.equipes_enviar);
        equipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Equipes equipes = helper.pegaEquipe();
                EquipesDAO dao = new EquipesDAO(EquipesActivity.this);

                dao.insere(equipes);
                dao.close();

                Toast.makeText(EquipesActivity.this, "Cor " + equipes.getNome() + " cadastrada!",
                        Toast.LENGTH_LONG).show();

                finish();
            }
        });

    }
}
