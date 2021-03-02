package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class TipoEndereco extends EntidadeDominio {
    private String nome;

    public TipoEndereco() {
        super();
        this.nome = "";
    }

    public TipoEndereco(String nome) {
        super();
        this.nome = nome;
    }

    public TipoEndereco(String nome, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
