package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class TipoUsuario extends EntidadeDominio {
    private String nome;

    public TipoUsuario() {
        super();
        this.nome = "";
    }

    public TipoUsuario(String nome) {
        super();
        this.nome = nome;
    }

    public TipoUsuario(String nome, int id, Date dt_cadastro) {
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
