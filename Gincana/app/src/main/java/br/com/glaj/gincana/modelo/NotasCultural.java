package br.com.glaj.gincana.modelo;

/**
 * Created by Anelise on 14/09/2017.
 */

public class NotasCultural {
    private Long id;
    private String professor;
    private String sala;
    private String prova;
    private Double nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getProva() {
        return prova;
    }

    public void setProva(String prova) {
        this.prova = prova;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return getId() + " - " + getProva();
    }
}
