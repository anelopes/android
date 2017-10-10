package br.com.glaj.gincana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EsportivaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esportiva);

        Button inserir = (Button) findViewById(R.id.esportiva_inserir);
        inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vaiParaInserir = new Intent(EsportivaActivity.this, EsportivaInserirActivity.class);
                startActivity(vaiParaInserir);
            }
        });

        Button darNotas = (Button) findViewById(R.id.esportiva_notas);
        darNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vaiParaDarNotas = new Intent(EsportivaActivity.this, EsportivaDarNotasActivity.class);
                startActivity(vaiParaDarNotas);
            }
        });
    }
}
