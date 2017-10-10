package br.com.glaj.gincana.modelo;

/**
 * Created by Anelise on 11/09/2017.
 */

public class EsportivaInserir {
    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
