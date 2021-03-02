package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class TipoTelefone extends EntidadeDominio {
    private String nome;

    public TipoTelefone() {
        super();
        this.nome = "";
    }

    public TipoTelefone(String nome) {
        super();
        this.nome = nome;
    }

    public TipoTelefone(String nome, int id, Date dt_cadastro) {
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
