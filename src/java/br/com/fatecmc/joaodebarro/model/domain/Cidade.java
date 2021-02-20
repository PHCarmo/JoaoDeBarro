package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Cidade extends EntidadeDominio {
    private String descricao;
    private Estado estado;

    public Cidade() {
        super();
        this.descricao = "";
        this.estado = new Estado();
    }

    public Cidade(String descricao, Estado estado) {
        super();
        this.descricao = descricao;
        this.estado = estado;
    }

    public Cidade(String descricao, Estado estado, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.descricao = descricao;
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
