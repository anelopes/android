package br.com.glaj.gincana.helper;

import android.widget.EditText;

import br.com.glaj.gincana.EsportivaInserirActivity;
import br.com.glaj.gincana.R;
import br.com.glaj.gincana.modelo.EsportivaInserir;

/**
 * Created by Anelise on 11/09/2017.
 */

public class EsportivaInserirHelper {

    private final EditText campoNome;
    private final EsportivaInserir esportivaInserir;

    public EsportivaInserirHelper(EsportivaInserirActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.esportiva_prova);

        esportivaInserir = new EsportivaInserir();

    }

    public EsportivaInserir pegaProva() {
        esportivaInserir.setNome(campoNome.getText().toString());
        return esportivaInserir;
    }
}
