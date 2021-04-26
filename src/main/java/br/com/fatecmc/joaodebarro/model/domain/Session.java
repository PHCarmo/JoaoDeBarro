package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class Session {
    private String id;
    private Date dt_criacao;

    public Session() {
        this.id = "";
        this.dt_criacao = new Date();
    }
    
    public Session(String id, Date dt_criacao) {
        this.id = id;
        this.dt_criacao = dt_criacao;
    }

    public Date getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(Date dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
