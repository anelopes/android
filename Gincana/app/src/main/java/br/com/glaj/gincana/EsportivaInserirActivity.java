package br.com.glaj.gincana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.glaj.gincana.dao.EsportivaInserirDAO;
import br.com.glaj.gincana.helper.EsportivaInserirHelper;
import br.com.glaj.gincana.modelo.EsportivaInserir;

public class EsportivaInserirActivity extends AppCompatActivity {

    private EsportivaInserirHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esportiva_inserir);

        helper = new EsportivaInserirHelper(this);

        final Button esportivaInserir = (Button) findViewById(R.id.esportiva_enviar);
        esportivaInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EsportivaInserir esportivaInserir = helper.pegaProva();
                EsportivaInserirDAO dao = new EsportivaInserirDAO(EsportivaInserirActivity.this);

                dao.insere(esportivaInserir);
                dao.close();

                Toast.makeText(EsportivaInserirActivity.this, "Prova " + esportivaInserir.getNome() + " cadastrada!",
                        Toast.LENGTH_SHORT).show();

                finish();

            }
        });
    }
}
