package br.com.glaj.gincana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.glaj.gincana.dao.CulturalDAO;
import br.com.glaj.gincana.helper.CulturalHelper;
import br.com.glaj.gincana.modelo.Cultural;

public class CulturalActivity extends AppCompatActivity {

    private CulturalHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cultural);

        helper = new CulturalHelper(this);

        final Button cultural = (Button) findViewById(R.id.cultural_enviar);
        cultural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cultural cultural = helper.pegaProva();
                CulturalDAO dao = new CulturalDAO(CulturalActivity.this);

                dao.insere(cultural);
                dao.close();

                Toast.makeText(CulturalActivity.this, "Prova " + cultural.getNome() +" cadastrada!",
                        Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }
}
