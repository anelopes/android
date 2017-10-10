package br.com.glaj.gincana;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import br.com.glaj.gincana.dao.CadastroDAO;
import br.com.glaj.gincana.dao.CulturalDAO;
import br.com.glaj.gincana.modelo.Cadastro;
import br.com.glaj.gincana.modelo.Cultural;

public class NotasActivity extends AppCompatActivity {

//    private NotasCulturalHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

       // Spinner de professores
        CadastroDAO dao = new CadastroDAO(this);
        List<Cadastro> usuarios = dao.buscaCadastro();
        dao.close();

        ArrayAdapter<Cadastro> adapterProfessores = new ArrayAdapter<Cadastro>(this, android.R.layout.simple_list_item_1, usuarios);

        Spinner sppinerProfessores = (Spinner) findViewById(R.id.notas_nomeProfessores);
        sppinerProfessores.setAdapter(adapterProfessores);

        //Sppiner de salas
        String[] salas = {"1ºA", "1ºB", "1ºC", "2ºA", "2ºB", "2ºC", "3ºA", "3ºB", "3ºC"};
        ArrayAdapter<String> adapterSalas = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, salas);

        Spinner sppinerSalas = (Spinner) findViewById(R.id.notas_salas);
        sppinerSalas.setAdapter(adapterSalas);

        //Spinner de provas
        CulturalDAO culturaDAO = new CulturalDAO(this);
        List<Cultural> prova = culturaDAO.buscaProva();
        dao.close();

        ArrayAdapter<Cultural> adapterProvas = new ArrayAdapter<Cultural>(this, android.R.layout.simple_list_item_1, prova);

        Spinner sppinerProvas = (Spinner) findViewById(R.id.notas_nomeProva);
        sppinerProvas.setAdapter(adapterProvas);

//        helper = new NotasCulturalHelper(this);

//        final Button enviar = (Button) findViewById(R.id.notas_enviar);
//        enviar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NotasCultural notasCultural = helper.pegaNotasCultural();
//                NotasCulturalDAO dao = new NotasCulturalDAO(NotasActivity.this);
//
//                dao.insere(notasCultural);
//                dao.close();
//
//                Toast.makeText(NotasActivity.this,
//                        "Nota " + notasCultural.getId() + " enviada!", Toast.LENGTH_SHORT).show();
//
//                finish();
//            }
//        });
    }
}
