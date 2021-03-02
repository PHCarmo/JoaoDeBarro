package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class TipoLogradouro extends EntidadeDominio {
    private String nome;

    public TipoLogradouro() {
        super();
        this.nome = "";
    }

    public TipoLogradouro(String nome) {
        super();
        this.nome = nome;
    }

    public TipoLogradouro(String nome, int id, Date dt_cadastro) {
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
