package br.com.glaj.gincana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EquipesProvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes_provas);

        Button cadastrarEquipes = (Button) findViewById(R.id.cadastrar_equipes);
        cadastrarEquipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vaiParaEquipes = new Intent(EquipesProvasActivity.this, EquipesActivity.class);
                startActivity(vaiParaEquipes);
            }
        });

        Button cadastrarProvas = (Button) findViewById(R.id.cadastrar_provas);
        cadastrarProvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vaiParaProvas = new Intent(EquipesProvasActivity.this, ProvasActivity.class);
                startActivity(vaiParaProvas);
            }
        });

        Button verUsuarios = (Button) findViewById(R.id.ver_usuarios);
        verUsuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vaiVerUsuarios = new Intent(EquipesProvasActivity.this, UsuariosActivity.class);
                startActivity(vaiVerUsuarios);
            }
        });
    }
}
