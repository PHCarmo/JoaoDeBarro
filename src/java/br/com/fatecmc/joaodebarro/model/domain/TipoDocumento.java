package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class TipoDocumento extends EntidadeDominio {
    private String nome;
    private String descricao;

    public TipoDocumento() {
        super();
        this.nome = "";
        this.descricao = "";
    }

    public TipoDocumento(String nome, String descricao) {
        super();
        this.nome = nome;
        this.descricao = descricao;
    }

    public TipoDocumento(String nome, String descricao, int id, Date dt_cadastro) {
        super(id, dt_cadastro);
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
