package br.com.glaj.gincana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notas = (Button) findViewById(R.id.main_notas);
        notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiPraNotas = new Intent(MainActivity.this, NotasActivity.class);
                startActivity(intentVaiPraNotas);
                Toast.makeText(MainActivity.this, "Página Notas selecionada", Toast.LENGTH_SHORT).show();

            }
        });

        Button adm = (Button) findViewById(R.id.main_adm);
        adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiPraAdm = new Intent(MainActivity.this, AdmActivity.class);
                startActivity(intentVaiPraAdm);
                Toast.makeText(MainActivity.this, "Página Administração selecionada", Toast.LENGTH_SHORT).show();

            }
        });

        Button resultados = (Button) findViewById(R.id.main_resultados);
        resultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiProsResultados = new Intent(MainActivity.this, ResultadoActivity.class);
                startActivity(intentVaiProsResultados);
                Toast.makeText(MainActivity.this, "Página Resultados selecionada", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
