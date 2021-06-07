package br.com.fatecmc.joaodebarro.model.domain;

import java.util.Date;

public class EntidadeDominio {
    private int id;
    private Date dt_cadastro;

    public EntidadeDominio() {
        this.id = 0;
        this.dt_cadastro = new Date();
    }

    public EntidadeDominio(int id, Date dt_cadastro) {
        this.id = id;
        this.dt_cadastro = dt_cadastro;
    }
    
    public int getId() {
        return id;
    }

    public EntidadeDominio setId(int id) {
        this.id = id;
        return this;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }
    
}
