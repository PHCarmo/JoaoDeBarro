package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class TipoResidencia extends EntidadeDominio {
    private String nome;

    public TipoResidencia() {
        super();
        this.nome = "";
    }

    public TipoResidencia(String nome) {
        super();
        this.nome = nome;
    }

    public TipoResidencia(String nome, int id, Date dt_cadastro) {
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
