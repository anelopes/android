package br.com.glaj.gincana.helper;

import android.view.View;
import android.widget.EditText;

import br.com.glaj.gincana.AdmActivity;
import br.com.glaj.gincana.CadastroActivity;
import br.com.glaj.gincana.NotasActivity;
import br.com.glaj.gincana.R;
import br.com.glaj.gincana.UsuariosActivity;
import br.com.glaj.gincana.modelo.Cadastro;

/**
 * Created by Anelise on 24/08/2017.
 */

public class CadastroHelper {
    private final EditText campoNome;
    private final EditText campoUsuario;
    private final EditText campoSenha;

    private final Cadastro cadastro;

    public CadastroHelper(CadastroActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.cadastro_nome);
        campoUsuario = (EditText) activity.findViewById(R.id.cadastro_usuario);
        campoSenha = (EditText) activity.findViewById(R.id.cadastro_password);

        cadastro = new Cadastro();

    }

    public Cadastro pegaCadastro() {
        cadastro.setNome(campoNome.getText().toString());
        cadastro.setUsuario(campoUsuario.getText().toString());
        cadastro.setSenha(campoSenha.getText().toString());
        return cadastro;
    }
}
