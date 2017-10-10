package br.com.glaj.gincana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas);

        Button cultural = (Button) findViewById(R.id.provas_cultural);
        cultural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiParaCultural = new Intent(ProvasActivity.this, CulturalActivity.class);
                startActivity(intentVaiParaCultural);
            }
        });

        Button esportiva = (Button) findViewById(R.id.provas_esportiva);
        esportiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVaiParaEsportiva = new Intent(ProvasActivity.this, EsportivaActivity.class);
                startActivity(intentVaiParaEsportiva);
            }
        });

    }
}
