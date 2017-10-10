package br.com.glaj.gincana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import br.com.glaj.gincana.dao.EsportivaInserirDAO;
import br.com.glaj.gincana.modelo.EsportivaInserir;

public class EsportivaDarNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esportiva_dar_notas);

        //Sppiner de Salas
        String[] salas = {"1ºA" , "1ºB", "1ºC", "2ºA", "2ºB", "2ºC", "3ºA", "3ºB", "3ºC"};
        ArrayAdapter<String> adapterSalas = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, salas);

        Spinner sppinerSalas = (Spinner) findViewById(R.id.dar_notas_salas);
        sppinerSalas.setAdapter(adapterSalas);

        //Spinner de provas
        EsportivaInserirDAO dao = new EsportivaInserirDAO(this);
        List<EsportivaInserir> prova = dao.buscaProva();
        dao.close();

        ArrayAdapter<EsportivaInserir> adapterProvas = new ArrayAdapter<EsportivaInserir>
                (this, android.R.layout.simple_list_item_1, prova);

        Spinner sppinerProvas = (Spinner) findViewById(R.id.dar_notas_provas);
        sppinerProvas.setAdapter(adapterProvas);
    }
}
