package br.com.glaj.gincana.helper;

import android.widget.EditText;

import br.com.glaj.gincana.CulturalActivity;
import br.com.glaj.gincana.R;
import br.com.glaj.gincana.modelo.Cultural;

/**
 * Created by Anelise on 05/09/2017.
 */

public class CulturalHelper {
    private final EditText campoNome;
    private final Cultural cultural;

    public CulturalHelper(CulturalActivity activity) {
    campoNome = (EditText) activity.findViewById(R.id.cultural_prova);

        cultural = new Cultural();
    }


    public Cultural pegaProva() {
        cultural.setNome(campoNome.getText().toString());
        return cultural;
    }
}
