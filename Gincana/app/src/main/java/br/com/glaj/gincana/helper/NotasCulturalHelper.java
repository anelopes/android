//package br.com.glaj.gincana.helper;
//
//import android.widget.EditText;
//import android.widget.Spinner;
//
//import br.com.glaj.gincana.NotasActivity;
//import br.com.glaj.gincana.R;
//import br.com.glaj.gincana.modelo.NotasCultural;
//
///**
// * Created by Anelise on 14/09/2017.
// */
//
//public class NotasCulturalHelper {
//    private final Spinner campoProfessor;
//    private final Spinner campoSala;
//    private final Spinner campoProva;
//    private final EditText campoNota;
//    private NotasCultural notasCultural;
//
//
//    public NotasCulturalHelper(NotasActivity activity) {
//        campoProfessor = (Spinner) activity.findViewById(R.id.notas_campoProfessores);
//        campoSala = (Spinner) activity.findViewById(R.id.notas_salas);
//        campoProva = (Spinner) activity.findViewById(R.id.notas_nomeProva);
//        campoNota = (EditText) activity.findViewById(R.id.notas_notaProva);
//
//        notasCultural = new NotasCultural();
//    }
//
//    public NotasCultural pegaNotasCultural() {
//        notasCultural.setProfessor(campoProfessor.getSelectedItem().toString());
//        notasCultural.setSala(campoSala.getSelectedItem().toString());
//        notasCultural.setProva(campoProva.getSelectedItem().toString());
//        notasCultural.setNota(Double.valueOf(campoNota.getText().toString()));
//        return notasCultural;
//    }
//}
//
