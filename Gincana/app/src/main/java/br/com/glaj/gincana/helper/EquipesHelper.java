package br.com.glaj.gincana.helper;

import android.widget.EditText;

import br.com.glaj.gincana.EquipesActivity;
import br.com.glaj.gincana.R;
import br.com.glaj.gincana.modelo.Equipes;

/**
 * Created by Anelise on 06/09/2017.
 */

public class EquipesHelper {

    private final Equipes equipes;
    private final EditText campoNome;

    public EquipesHelper(EquipesActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.equipes_cores);

        equipes = new Equipes();
    }

    public Equipes pegaEquipe() {
        equipes.setNome(campoNome.getText().toString());

        return equipes;
    }
}
