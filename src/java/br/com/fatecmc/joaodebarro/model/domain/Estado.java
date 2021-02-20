package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Estado extends EntidadeDominio {
    private String descricao;

    public Estado() {
        super();
        this.descricao = "";
    }

    public Estado(String descricao) {
        super();
        this.descricao = descricao;
    }

    public Estado(String descricao, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
