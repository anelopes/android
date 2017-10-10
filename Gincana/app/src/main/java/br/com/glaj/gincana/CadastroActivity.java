package br.com.glaj.gincana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.glaj.gincana.dao.CadastroDAO;
import br.com.glaj.gincana.helper.CadastroHelper;
import br.com.glaj.gincana.modelo.Cadastro;

public class CadastroActivity extends AppCompatActivity {

    private CadastroHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        helper = new CadastroHelper(this);

        final Button cadastro = (Button) findViewById(R.id.cadastro_enviar);
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cadastro cadastro = helper.pegaCadastro();
                CadastroDAO dao = new CadastroDAO(CadastroActivity.this);

                dao.insere(cadastro);
                dao.close();

                Toast.makeText(CadastroActivity.this, "Cadastro de " + cadastro.getNome() +" realizado!",
                        Toast.LENGTH_LONG).show();

                finish();
            }
        });
    }
}
