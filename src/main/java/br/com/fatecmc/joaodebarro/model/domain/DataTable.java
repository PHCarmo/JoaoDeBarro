package br.com.fatecmc.joaodebarro.model.domain;

import java.util.ArrayList;
import java.util.List;

public class DataTable extends EntidadeDominio {
    private String nome;
    private List<EntidadeDominio> elementos;

    public DataTable() {
        super();
        this.nome = "";
        this.elementos = new ArrayList<>();
    }

    public DataTable(String nome, List<EntidadeDominio> elementos) {
        super();
        this.nome = nome;
        this.elementos = elementos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EntidadeDominio> getElementos() {
        return elementos;
    }

    public void setElementos(List<EntidadeDominio> elementos) {
        this.elementos = elementos;
    }
    
}
