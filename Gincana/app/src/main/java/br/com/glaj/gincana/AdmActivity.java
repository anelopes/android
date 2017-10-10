package br.com.glaj.gincana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.glaj.gincana.dao.CadastroDAO;
import br.com.glaj.gincana.modelo.Cadastro;

public class AdmActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm);

        usuario = (EditText) findViewById(R.id.adm_usuario);
        senha = (EditText) findViewById(R.id.adm_password);

        final Button cadastro = (Button) findViewById(R.id.adm_cadastrar);
        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vaiParaCadastro = new Intent(AdmActivity.this, CadastroActivity.class);
                startActivity(vaiParaCadastro);
            }
        });

        Button entrar = (Button) findViewById(R.id.adm_entrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuarioInformado = usuario.getText().toString();
                String senhaInformada = senha.getText().toString();

                CadastroDAO dao = new CadastroDAO(AdmActivity.this);
                Cadastro users = new Cadastro();

                users.setUsuario(usuarioInformado);
                users.setSenha(senhaInformada);

                boolean valido = dao.isUserValid(users);

                if (valido) {
                    startActivity(new Intent(AdmActivity.this, EquipesProvasActivity.class));
                }

                else {
                    Toast.makeText(AdmActivity.this, "Usuário ou senha inválido", Toast.LENGTH_SHORT).show();
                }
            }


        });

    }
}